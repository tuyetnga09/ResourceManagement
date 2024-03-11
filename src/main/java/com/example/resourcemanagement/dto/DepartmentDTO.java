package com.example.resourcemanagement.dto;
import com.example.resourcemanagement.models.TasksWork;
import com.example.resourcemanagement.models.User;
import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class DepartmentDTO {
    private Long id;
    @NotEmpty(message = "Club title should not be empty")
    private String nameDepartment;
    @NotEmpty(message = "Club title should not be empty")
    private String description;
    @NotEmpty(message = "Club title should not be empty")
    private String nameManager;
    @NotEmpty(message = "Club title should not be empty")
    private Integer quantityMember;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private User createdBy;
    private List<TasksWorkDTO> tasksWorks;
}
