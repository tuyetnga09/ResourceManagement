package com.example.resourcemanagement.service.impl;

import com.example.resourcemanagement.dto.TasksWorkDTO;
import com.example.resourcemanagement.models.Department;
import com.example.resourcemanagement.models.TasksWork;
import com.example.resourcemanagement.models.User;
import com.example.resourcemanagement.repository.DepartmentRepository;
import com.example.resourcemanagement.repository.TasksWorkRepository;
import com.example.resourcemanagement.repository.UserRepository;
import com.example.resourcemanagement.security.SecurityUtil;
import com.example.resourcemanagement.service.TasksWorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.resourcemanagement.mapper.DepartmentMapper.mapToDepartment;
import static com.example.resourcemanagement.mapper.TasksWorkMapper.mapToTasksWork;
import static com.example.resourcemanagement.mapper.TasksWorkMapper.mapToTasksworkDto;

@Service
public class TasksWorkServiceImpl implements TasksWorkService {
    @Autowired
    private TasksWorkRepository tasksWorkRepository;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Override
    public void createTaskWork(Long taskWorkId, TasksWorkDTO tasksWorkDTO) {
        Department department = departmentRepository.findById(taskWorkId).get();
        TasksWork tasksWork = mapToTasksWork(tasksWorkDTO);
        tasksWork.setDepartment(department);
        tasksWorkRepository.save(tasksWork);

    }

    @Override
    public List<TasksWorkDTO> findAll() {
        List<TasksWork> tasksWorks = tasksWorkRepository.findAll();
        return tasksWorks.stream().map((tasksWork) -> mapToTasksworkDto(tasksWork)).collect(Collectors.toList());
    }

    @Override
    public TasksWorkDTO findByTasksWork(Long taskWorkId) {
        TasksWork tasksWork = tasksWorkRepository.findById(taskWorkId).get();
        return mapToTasksworkDto(tasksWork);
    }

    @Override
    public void updateTasksWOrk(TasksWorkDTO tasksWorkDTO) {
        TasksWork tasksWork = mapToTasksWork(tasksWorkDTO);
        tasksWorkRepository.save(tasksWork);
    }

    @Override
    public void deleteTaskWork(long taskWorkId) {
        tasksWorkRepository.deleteById(taskWorkId);
    }
}
