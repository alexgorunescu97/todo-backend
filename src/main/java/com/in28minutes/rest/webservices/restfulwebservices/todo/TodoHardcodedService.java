package com.in28minutes.rest.webservices.restfulwebservices.todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoHardcodedService {

    private static final List<Todo> todos = createTodoList();
    private static long idCounter;

    private static List<Todo> createTodoList() {

        List<Todo> todos = new ArrayList<>();

        todos.add(new Todo(++idCounter, "test1", "learn java", LocalDate.now(), false));
        todos.add(new Todo(++idCounter, "test2", "learn javascript", LocalDate.now(), true));
        todos.add(new Todo(++idCounter, "test3", "learn python", LocalDate.now(), false));

        return todos;
    }

    public List<Todo> findAll() {
        return todos;
    }

    public Todo findById(long id) {
        return todos.stream().filter(t -> t.getId() == id).findFirst().orElse(null);
    }

    public Todo deleteById(long id) {
        Todo todo = findById(id);
        todos.remove(todo);
        return todo;
    }

    public Todo save(Todo todo) {
        if (todo.getId() == 0) {
            todo.setId(++idCounter);
            todos.add(todo);
        } else {
            Todo todoDeleted = deleteById(todo.getId());
            if (todoDeleted != null) {
                todos.add(todo);
            }
        }

        return todo;
    }
}
