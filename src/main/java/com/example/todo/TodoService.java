/*
 * You can use the following import statements
 * 
 * import org.springframework.web.server.ResponseStatusException;
 * import org.springframework.http.HttpStatus;
 * 
 */

package com.example.todo;


import java.util.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

// Do not modify the below code

public class TodoService implements TodoRepository {

    private static HashMap<Integer, Todo> todoList = new HashMap<>();

    public TodoService() {
        todoList.put(1, new Todo(1, "Watch Movie", "LOW", "TO DO"));
        todoList.put(2, new Todo(2, "Finish Project", "HIGH", "IN PROGRESS"));
        todoList.put(3, new Todo(3, "Buy Groceries", "MEDIUM", "TO DO"));
        todoList.put(4, new Todo(4, "Learning from NxtWave", "HIGH", "IN PROGRESS"));
        todoList.put(5, new Todo(5, "Go for a Run", "MEDIUM", "DONE"));

    }

    // Do not modify the above code

    // Write your code here
   
    // Do not modify the above code

    // Write your code here
int uniqueId=6;

    @Override
    public ArrayList<Todo> getTodos(){
        Collection<Todo> todosValues = todoList.values();
        ArrayList<Todo> employees = new ArrayList<>(todosValues);
        return employees;
    }

    @Override
    public Todo getTodoById(int id){
        Todo existingTodo = todoList.get(id);
        if (existingTodo==null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return existingTodo;
    }

    @Override
    public Todo addTodo(Todo todo){
        todo.setId(uniqueId);
        todoList.put(uniqueId, todo);
        Todo todo1 = todoList.get(uniqueId);
        uniqueId+=1;
        return todo1;

    }

    @Override
    public Todo updateTodo(int id, Todo todo){
        Todo existingTodo = todoList.get(id);
        if (existingTodo==null){
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        if (todo.getTodo()!=null){
            existingTodo.setTodo(todo.getTodo());
        }
        if (todo.getPriority()!=null){
            existingTodo.setPriority(todo.getPriority());
        }
        if (todo.getStatus()!=null){
            existingTodo.setStatus(todo.getStatus());
        }
        return existingTodo;
    }

    @Override
    public void deleteTodo(int id){
        Todo existingTodo = todoList.get(id);
        if (existingTodo!=null){
            todoList.remove(id);
            throw new ResponseStatusException(HttpStatus.NO_CONTENT);
        }else{
        throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}



