package org.mockitobasic.stub;

import org.mockitorbasic.api.ToDoService;

import java.util.Arrays;
import java.util.List;

public class ToDoServiceStub implements ToDoService {
    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC","Learn Springboot","Learn to Dance");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
