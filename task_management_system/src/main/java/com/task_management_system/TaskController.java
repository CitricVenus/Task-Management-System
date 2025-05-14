package com.task_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping
    public List<Task> getAllTasks(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id){
        return taskService.getTaskById(id);

    }

    @PostMapping
    public Task addNewTask(@Valid @RequestBody Task task){
        System.out.println("Received task: " + task.toString());
        return taskService.addNewTask(task);
    }

    @PutMapping("/{id}")
    public Optional<Task> updateTaskById(@Valid @RequestBody Task task, @PathVariable Long id){
        return taskService.updateTaskById(task,id);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id){
            taskService.deleteTask(id);
    }


}
