package com.example.resourcemanagement.service;

import com.example.resourcemanagement.dto.DepartmentDTO;
import com.example.resourcemanagement.models.Department;

import java.util.List;

public interface DepartmentService {
    Department createDepartment(DepartmentDTO departmentDTO);
    List<DepartmentDTO> findAll();
    DepartmentDTO findByDepartmentId(Long departmentId);
    void updateDepartment(DepartmentDTO departmentDTO);
    void deleteDepartment(long departmentId);
}
