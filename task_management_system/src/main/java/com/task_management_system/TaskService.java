package com.task_management_system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;


    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskById(Long id){
        return taskRepository.findById(id)
                .orElseThrow(() -> new ItemNotFound("Task with ID: " + id + " doesn't exist"));
    }

    public Task addNewTask(Task task){
            if (task.getStatus() != null && (!task.getTitle().equals("") && !task.getTitle().isEmpty())){
                return taskRepository.save(task);
            }else{
                throw new InvalidValues("Check your values status can't be null and title can't be null neither empty");
            }

    }

    public Optional<Task> updateTaskById(Task taskDetail,Long id){
        if (taskRepository.findById(id).isPresent()){
            return taskRepository.findById(id).map(taskAux ->{
                taskAux.setTitle(taskDetail.getTitle());
                taskAux.setDescription(taskDetail.getDescription());
                taskAux.setStatus(taskDetail.getStatus());
                return taskRepository.save(taskAux);
            });
        }else {
            throw new ItemNotFound("Task with ID: " +id+ " doesn't exist");
        }

    }

    public void deleteTask(Long id){
        if (taskRepository.findById(id).isPresent()){
            taskRepository.deleteById(id);
        }else{
            throw new ItemNotFound("Task with ID: " +id+ " doesn't exist");
        }
    }

}
