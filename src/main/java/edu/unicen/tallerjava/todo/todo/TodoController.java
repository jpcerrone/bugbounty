package edu.unicen.tallerjava.todo.todo;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.unicen.tallerjava.todo.users.CurrentUserService;

@RestController
class TodoController {
    @Autowired
    private
    TodoService svc;

    @GetMapping(value = "/api/todo", produces = "application/json")
    public @ResponseBody
    Iterable<ToDo> getTodoList() {
        return svc.getTodoList();
    }

    @DeleteMapping(value = "/api/todo", produces = "application/json")
    public void deleteTodo(@RequestBody ToDo todo) {
        svc.delete(todo.getId());
    }

    @PostMapping(value = "/api/todo", produces = "application/json")
    public @ResponseBody
    ToDo addTodo(@RequestBody ToDo todo) {
        return svc.createNewTodo(todo.getContent());
    }
}
