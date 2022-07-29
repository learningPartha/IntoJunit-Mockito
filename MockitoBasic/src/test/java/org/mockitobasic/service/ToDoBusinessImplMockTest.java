package org.mockitobasic.service;

import org.junit.Test;
import org.mockitorbasic.api.ToDoService;
import org.mockitorbasic.service.ToDoBusinessImpl;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.mockito.BDDMockito.given;

public class ToDoBusinessImplMockTest {

    @Test
    public void testTodoServiceMock(){
        ToDoService toDoService = mock(ToDoService.class);//create mock on class
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(toDoService.retrieveTodos("Ranga")).thenReturn(allTodos);//when mock is called return specific value
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> todos = toDoBusiness.retrieveTodosRelatedtoSpring("Ranga");
        assertEquals(2,todos.size());
    }

    @Test
    public void testTodoServiceMockBDD(){//Mockito using BDD
        //Given
        ToDoService toDoService = mock(ToDoService.class);//create mock on class
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        given(toDoService.retrieveTodos("Ranga")).willReturn(allTodos);
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        //When
        List<String> todos = toDoBusiness.retrieveTodosRelatedtoSpring("Ranga");
        //Then
        assertThat(todos.size(),is(2));
    }

}
