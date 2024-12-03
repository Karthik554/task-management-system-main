package com.application.task_springboot.services.admin;


import com.application.task_springboot.dto.CommentDTO;
import com.application.task_springboot.dto.TaskDto;
import com.application.task_springboot.dto.UserDto;
import org.springframework.scheduling.config.Task;

import java.util.List;

public interface AdminService {

    List<UserDto> getUsers();

    TaskDto createTask(TaskDto taskDTO);

    List<TaskDto> getAllTasks();

    void deleteTask(Long id);

    TaskDto updateTask(Long id, TaskDto taskDTO);

    List<TaskDto> searchTaskByTitle(String title);

    TaskDto getTaskById(Long id);

    CommentDTO createComment(Long taskId, String content);

    List<CommentDTO> getCommentsByTaskId(Long taskId);
}
