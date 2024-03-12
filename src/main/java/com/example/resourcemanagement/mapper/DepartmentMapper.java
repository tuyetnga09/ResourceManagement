package com.example.resourcemanagement.mapper;

import com.example.resourcemanagement.dto.DepartmentDTO;
import com.example.resourcemanagement.models.Department;

import java.util.stream.Collectors;

import static com.example.resourcemanagement.mapper.TasksWorkMapper.mapToTasksworkDto;

public class DepartmentMapper {
    public static DepartmentDTO mapToDepartmentDTO(Department department) {
        DepartmentDTO departmentDTO = DepartmentDTO.builder()
                .id(department.getId())
                .nameDepartment(department.getNameDepartment())
                .description(department.getDescription())
                .nameDepartment(department.getNameManager())
                .quantityMember(department.getQuantityMember())
                .createdBy(department.getCreatedBy())
                .createdOn(department.getCreatedOn())
                .updatedOn(department.getUpdatedOn())
                .tasksWorks(department.getTasksWorks().stream().map((tasksWork) -> mapToTasksworkDto(tasksWork)).collect(Collectors.toList()))
                .build();
        return departmentDTO;
    }

    public static Department mapToDepartment(DepartmentDTO departmentDTO) {
        Department department = Department.builder()
                .id(departmentDTO.getId())
                .nameDepartment(departmentDTO.getNameDepartment())
                .description(departmentDTO.getDescription())
                .nameManager(departmentDTO.getNameManager())
                .quantityMember(departmentDTO.getQuantityMember())
                .createdBy(departmentDTO.getCreatedBy())
                .createdOn(departmentDTO.getCreatedOn())
                .updatedOn(departmentDTO.getUpdatedOn())
                .build();
        return  department;
    }

}
