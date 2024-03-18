package com.example.resourcemanagement.service;

import com.example.resourcemanagement.dto.TasksWorkDTO;
import com.example.resourcemanagement.models.TasksWork;

import java.util.List;

public interface TasksWorkService {
    void createTaskWork(Long taskWorkId, TasksWorkDTO tasksWorkDTO);
    List<TasksWorkDTO> findAll();
    TasksWorkDTO findByTasksWork(Long taskWorkId);
    void updateTasksWOrk(TasksWorkDTO tasksWorkDTO);
    void deleteTaskWork(long taskWorkId);
}
