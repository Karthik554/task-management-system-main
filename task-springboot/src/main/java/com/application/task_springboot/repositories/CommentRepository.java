package com.application.task_springboot.repositories;

import com.application.task_springboot.dto.CommentDTO;
import com.application.task_springboot.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : A.S.M.M.U.P.Adhikaram
 * @Since : 10/4/2024
 * @Time : 7:49 PM
 **/

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByTaskId(Long taskId);
}
