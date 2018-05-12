package com.rogercw.mockito;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 2018/5/12.
 * 行为验证
 */
public class MockitoInvocationTest {

    @Test
    public void invocationTest() {
        ArrayList<Integer> mockList= mock(ArrayList.class);

        mockList.add(1);
        mockList.add(2);
        mockList.add(2);

        //验证次数
        verify(mockList,times(1)).add(1);
        verify(mockList,times(2)).add(2);

        //用atLeast()/atMost()验证
        verify(mockList,atLeast(2)).add(2);
        verify(mockList,atMost(2)).add(1);
        //add(3)从未使用
        verify(mockList,atMost(1)).add(3);

        //从未使用验证,下面两句是等价的
        verify(mockList,times(0)).add(4);
        verify(mockList,never()).add(4);

    }
}
