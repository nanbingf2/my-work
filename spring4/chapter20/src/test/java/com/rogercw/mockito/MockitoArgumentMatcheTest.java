package com.rogercw.mockito;

import static org.mockito.Mockito.*;

import static org.testng.Assert.*;

import org.mockito.internal.exceptions.ExceptionIncludingMockitoWarnings;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 1 on 2018/5/12.
 * 参数匹配
 */
public class MockitoArgumentMatcheTest {

    @Test
    public void testArgumentMatche() {
        Map<String,String> mockMap=mock(HashMap.class);
        //使用anyString()参数匹配器,当调用get（）方法时总是返回Mock
        when(mockMap.get(anyString())).thenReturn("Mock");

        String mock1 = mockMap.get("mock1");
        String mock2 = mockMap.get("mock2");

        assertEquals(mock1,"Mock");
        assertEquals(mock2,"Mock");

        doNothing().when(mockMap).clear();
        doThrow(new RuntimeException()).when(mockMap).clear();
    }
}
