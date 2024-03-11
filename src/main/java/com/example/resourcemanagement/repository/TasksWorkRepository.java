package com.example.resourcemanagement.repository;

import com.example.resourcemanagement.models.TasksWork;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksWorkRepository extends JpaRepository<TasksWork, Long> {
}
