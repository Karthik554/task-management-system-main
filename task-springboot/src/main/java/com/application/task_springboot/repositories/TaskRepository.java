package com.application.task_springboot.repositories;

import com.application.task_springboot.dto.TaskDto;
import com.application.task_springboot.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : A.S.M.M.U.P.Adhikaram
 * @Since : 9/11/2024
 * @Time : 1:05 AM
 **/

@Repository
public interface TaskRepository extends JpaRepository<Task,Long> {

    List<Task> findAllByTitleContaining(String title);

    List<Task> findAllByUserId(Long id);
}
