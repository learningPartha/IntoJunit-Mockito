package org.mockitobasic.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockitorbasic.api.ToDoService;
import org.mockitorbasic.service.ToDoBusinessImpl;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)// if you are using mock directly outside of method
public class ToDoBusinessImplInjectMockTest {

    @Mock
    ToDoService toDoService;//create dependency

    @InjectMocks
    ToDoBusinessImpl toDoBusiness;//inject todobusiness impl

    @Captor
    ArgumentCaptor<String> argumentCaptor;

    @Test
    public void testTodoServiceMock() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        when(toDoService.retrieveTodos("Ranga")).thenReturn(allTodos);//when mock is called return specific value
        List<String> todos = toDoBusiness.retrieveTodosRelatedtoSpring("Ranga");
        assertEquals(2, todos.size());
    }

    @Test
    public void testTodoServiceMockBDD() {//Mockito using BDD
        //Given
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        given(toDoService.retrieveTodos("Ranga")).willReturn(allTodos);
        //When
        List<String> todos = toDoBusiness.retrieveTodosRelatedtoSpring("Ranga");
        //Then
        assertThat(todos.size(), is(2));
    }

    @Test
    public void testDeleteNow() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(toDoService.retrieveTodos("Ranga")).thenReturn(allTodos);
        toDoBusiness.deleteTodosNotRelatedToSpring("Ranga");
        verify(toDoService).deleteTodo("Learn to Dance");
        verify(toDoService, Mockito.never()).deleteTodo("Learn Spring MVC");
        verify(toDoService, Mockito.never()).deleteTodo("Learn Spring");
        verify(toDoService, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast
    }

    @Test
    public void testDeleteArgCaptor(){
        //given
        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");
        given(toDoService.retrieveTodos("Range")).willReturn(allTodos);
        //when
        toDoBusiness.deleteTodosNotRelatedToSpring("Range");
        //then
        verify(toDoService).deleteTodo(argumentCaptor.capture());
        assertEquals("Learn to Dance",argumentCaptor.getValue());
    }
}
