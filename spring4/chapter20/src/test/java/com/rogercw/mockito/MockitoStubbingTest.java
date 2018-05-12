package com.rogercw.mockito;

import static org.mockito.Mockito.*;

import static org.testng.Assert.*;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/5/12.
 * Stubbing测试
 */
public class MockitoStubbingTest {

    @Test
    public void testStubbing() {
        Map<String ,String> map=mock(HashMap.class);
        //设置值
        when(map.get("username")).thenReturn("zhangsan");
        when(map.get("password")).thenReturn("1234");

        //进行调用
        String username = map.get("username");
        assertEquals(username,"zhangsan");
        //调用没有设置值的方法,将返回null
        String age=map.get("age");
        assertNull(age);

        verify(map,times(1)).get("username");
        verify(map,times(1)).get("age");
        verify(map,never()).get("password");
    }
}
