/*
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 * 
 */

// Write your code here
package com.example.todo;

import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
public class TodoController {

    TodoService todoService = new TodoService();

    @GetMapping("/todos")
    public ArrayList<Todo> getTodos(){
        return todoService.getTodos();
    }

    @GetMapping("/todos/{id}")
    public Todo GetTodoById(@PathVariable ("id") int id){
        return todoService.getTodoById(id);
    }

    @PostMapping("/todos")
    public Todo addTodo(@RequestBody Todo todo){
        return todoService.addTodo(todo);
    }

    @PutMapping("/todos/{id}")
    public Todo updateTodo(@PathVariable ("id") int id, @RequestBody Todo todo){
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/todos/{id}")
    public void deleteTodo(@PathVariable ("id") int id){
        todoService.deleteTodo(id);
    }

}
