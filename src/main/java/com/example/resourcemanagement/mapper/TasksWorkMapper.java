package com.example.resourcemanagement.mapper;

import com.example.resourcemanagement.dto.TasksWorkDTO;
import com.example.resourcemanagement.models.TasksWork;

public class TasksWorkMapper {
    public static TasksWorkDTO mapToTasksworkDto(TasksWork tasksWork) {
        return TasksWorkDTO.builder()
                .id(tasksWork.getId())
                .name(tasksWork.getName())
                .startTime(tasksWork.getStartTime())
                .endTime(tasksWork.getEndTime())
                .type(tasksWork.getType())
                .createdOn(tasksWork.getCreatedOn())
                .updatedOn(tasksWork.getUpdatedOn())
                .department(tasksWork.getDepartment())
                .build();
    }

    public static TasksWork mapToTasksWork(TasksWorkDTO tasksWorkDTO) {
        TasksWork tasksWork = TasksWork.builder()
                .id(tasksWorkDTO.getId())
                .name(tasksWorkDTO.getName())
                .startTime(tasksWorkDTO.getStartTime())
                .endTime(tasksWorkDTO.getEndTime())
                .type(tasksWorkDTO.getType())
                .createdOn(tasksWorkDTO.getCreatedOn())
                .updatedOn(tasksWorkDTO.getUpdatedOn())
                .build();
        return  tasksWork;
    }

}
