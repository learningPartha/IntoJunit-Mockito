package org.mockitobasic.service;

import org.junit.Test;
import org.mockitobasic.stub.ToDoServiceStub;
import org.mockitorbasic.api.ToDoService;
import org.mockitorbasic.service.ToDoBusinessImpl;

import java.util.List;
import static org.junit.Assert.assertEquals;

public class ToDoBusinessImplStubTest {

    @Test
    public void testTodoServiceStub(){
        ToDoService toDoService = new ToDoServiceStub();
        ToDoBusinessImpl toDoBusiness = new ToDoBusinessImpl(toDoService);
        List<String> todos = toDoBusiness.retrieveTodosRelatedtoSpring("Ranga");
        System.out.println(todos.toString());
        assertEquals(2,todos.size());
    }

}
