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
}
