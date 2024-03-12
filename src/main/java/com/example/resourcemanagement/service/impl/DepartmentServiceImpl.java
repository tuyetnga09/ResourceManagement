package com.example.resourcemanagement.service.impl;

import com.example.resourcemanagement.dto.DepartmentDTO;
import com.example.resourcemanagement.models.Department;
import com.example.resourcemanagement.models.User;
import com.example.resourcemanagement.repository.DepartmentRepository;
import com.example.resourcemanagement.repository.UserRepository;
import com.example.resourcemanagement.security.SecurityUtil;
import com.example.resourcemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.resourcemanagement.mapper.DepartmentMapper.mapToDepartment;
import static com.example.resourcemanagement.mapper.DepartmentMapper.mapToDepartmentDTO;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public Department createDepartment(Long departmentId, DepartmentDTO departmentDTO) {
        String username = SecurityUtil.getSessionUser();
        User user = userRepository.findByUsername(username);
        Department department = mapToDepartment(departmentDTO);
        department.setCreatedBy(user);
        return departmentRepository.save(department);
    }

    @Override
    public List<DepartmentDTO> findAll() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department) -> mapToDepartmentDTO(department)).collect(Collectors.toList());
    }

    @Override
    public DepartmentDTO findByDepartmentId(Long departmentId) {
        return null;
    }

    @Override
    public void updateDepartment(DepartmentDTO departmentDTO) {

    }

    @Override
    public void deleteDepartment(long departmentId) {

    }
}
