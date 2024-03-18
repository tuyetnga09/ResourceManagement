package com.example.resourcemanagement.controller;

import com.example.resourcemanagement.dto.DepartmentDTO;
import com.example.resourcemanagement.models.Department;
import com.example.resourcemanagement.models.User;
import com.example.resourcemanagement.security.SecurityUtil;
import com.example.resourcemanagement.service.DepartmentService;
import com.example.resourcemanagement.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private UserService userService;


    @GetMapping("/getAll")
    public String listDepartment(Model model) {
        User user = new User();
        List<DepartmentDTO> departmentDTOList = departmentService.findAll();
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("department", departmentDTOList);
        return "department-list";
    }
    @GetMapping("/{departmentId}")
    public String departmentDetail(@PathVariable("departmentId") long departmentId, Model model) {
        User user = new User();
        DepartmentDTO departmentDTO = departmentService.findByDepartmentId(departmentId);
        String username = SecurityUtil.getSessionUser();
        if(username != null) {
            user = userService.findByUsername(username);
            model.addAttribute("user", user);
        }
        model.addAttribute("user", user);
        model.addAttribute("department", departmentDTO);
        return "department-detail";
    }

    @GetMapping("/new")
    public String createDepartmentForm(Model model) {
        Department department = new Department();
        model.addAttribute("department", department);
        return "department-create";
    }
    @PostMapping("/new")
    public String saveClub(@Valid @ModelAttribute("department") DepartmentDTO departmentDTO, BindingResult result, Model model) {
        if(result.hasErrors()) {
            model.addAttribute("department", departmentDTO);
            return "department-create";
        }
        departmentService.createDepartment(departmentDTO);
        return "redirect:/api/department/getAll";
    }

}
