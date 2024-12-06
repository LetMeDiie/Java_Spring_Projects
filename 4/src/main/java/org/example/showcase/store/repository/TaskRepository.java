package org.example.showcase.store.repository;

import org.example.showcase.store.entity.TaskEntity;
import org.example.showcase.store.enums.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<TaskEntity,Long> {
    List<TaskEntity> findByTaskStatus(TaskStatus taskStatus);
}
