package com.rogercw.mockito;
import static org.mockito.Mockito.*;

import com.rogercw.domain.MockTest;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by 1 on 2018/5/12.
 */
public class MockitoVerificationInOrderTest {

    @Test
    public void testVerificationInOrder() {
        // A. 单个mock对象他的方法必须按照顺序来调用。
        List singleMock = mock(List.class);

        //使用单个mock
        singleMock.add("was added first");
        singleMock.add("was added second");

        //为单个Mock创建一个InOrder的顺序验证
        InOrder inOrder = inOrder(singleMock);

        //下面需要确保第一次调用的是“was added first”，然后是"was added second"
        inOrder.verify(singleMock).add("was added first");
        inOrder.verify(singleMock).add("was added second");

        // B. 多个mock也必须按照顺序来使用
        List firstMock = mock(List.class);
        List secondMock = mock(List.class);

        //使用mock
        firstMock.add("was called first");
        secondMock.add("was called second");

        //创建一个inOrder对象，把需要按照顺序验证的mock传递进去。
        InOrder inOrder2 = inOrder(firstMock, secondMock);

        //保证firstMock在secondMock之前调用
        inOrder2.verify(firstMock).add("was called first");
        inOrder2.verify(secondMock).add("was called second");
    }

    @Test
    public void testInteractionNeverHappened() {
        List mockList1=mock(List.class);
        List mockList2=mock(List.class);
        mockList1.add(1);
        mockList1.add(2);
        verify(mockList1,times(1)).add(1);
        //验证通过,因为mockList2还没有进行任何操作
        verifyZeroInteractions(mockList2);
        //验证不通过,因为mockList1的add（2）方法没有经过验证
        verifyZeroInteractions(mockList1);
    }

    @Test
    public void testFindingRedundantInvocations() {
        List mockList=mock(List.class);
        mockList.add(1);
        mockList.add(2);

        verify(mockList).add(1);
        //验证失败,因为add（2）方法还未验证
        verifyNoMoreInteractions(mockList);
    }

    @Mock
    private List mockList;

    @BeforeClass
    public void inti(){
        //初始化当前测试类中所有@Mock注解模拟对象
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testStubbingConsecutiveCalls() throws Exception {

        MockTest mock = mock(MockTest.class);
        when(mock.someMethod("some arg")).thenThrow(new RuntimeException("")).thenReturn("foo");

        //第一次调用，抛RuntimeException
        mock.someMethod("some arg");

        //第二次调用返回foo
        System.out.println(mock.someMethod("some arg"));

        //后续继续调用，返回“foo”，以最后一个stub为准
        System.out.println(mock.someMethod("some arg"));

        //下面是一个更简洁的写法
        when(mock.someMethod("some arg")).thenReturn("one", "two", "three");
    }

}
