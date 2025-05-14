package com.task_management_system;

public class TaskAlreadyExist extends RuntimeException{
    public TaskAlreadyExist(String message){
        super(message);
    }
}
