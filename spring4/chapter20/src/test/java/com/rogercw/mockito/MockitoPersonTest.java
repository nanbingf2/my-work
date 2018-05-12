package com.rogercw.mockito;

import com.rogercw.dao.PersonDao;
import com.rogercw.domain.Person;
import com.rogercw.service.impl.PersonServiceImpl;
import static org.mockito.Mockito.*;

import static org.testng.Assert.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by 1 on 2018/5/11.
 */
public class MockitoPersonTest {

    private PersonDao mockPersonDao;
    private PersonServiceImpl mockPersonService;

    @BeforeClass
    public void inti(){
        mockPersonDao= mock(PersonDao.class);
        when(mockPersonDao.findPersonById(1)).thenReturn(new Person(1,"zhangsan"));
        when(mockPersonDao.update(isA(Person.class))).thenReturn(true);
        mockPersonService=new PersonServiceImpl(mockPersonDao);
    }
    
    @Test
    public void testUpdate() {
        boolean result = mockPersonService.update(1, "lisi");
        assertTrue(result);
        //验证是否执行过一次findPersonById（）
        verify(mockPersonDao,times(1)).findPersonById(1);
        verify(mockPersonDao,times(1)).update(isA(Person.class));
    }

    @Test
    public void testUpdateNotFind() throws Exception {
        boolean result = mockPersonService.update(2, "new name");
        assertFalse(result);
        //验证是否执行过一次getPerson(1)
        verify(mockPersonDao, times(0)).findPersonById(1);
        //验证是否执行过一次update
        verify(mockPersonDao, never()).update(isA(Person.class));
    }
}
