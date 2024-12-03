package com.application.task_springboot.services.employee;

import com.application.task_springboot.dto.CommentDTO;
import com.application.task_springboot.dto.TaskDto;
import com.application.task_springboot.entities.Comment;
import com.application.task_springboot.entities.Task;
import com.application.task_springboot.entities.User;
import com.application.task_springboot.enums.TaskStatus;
import com.application.task_springboot.repositories.CommentRepository;
import com.application.task_springboot.repositories.TaskRepository;
import com.application.task_springboot.utils.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author : A.S.M.M.U.P.Adhikaram
 * @Since : 10/2/2024
 * @Time : 10:42 PM
 **/
@Service
@RequiredArgsConstructor

public class EmployeeServiceImpl implements EmployeeService{

    private final TaskRepository taskRepository;

    private final JwtUtil jwtUtil;

    private final CommentRepository commentRepository;

    @Override
    public List<TaskDto> getTaskByUserId() {
        User user = jwtUtil.getLoggedInUser();
        if(user != null){
            return taskRepository.findAllByUserId(user.getId())
                    .stream()
                    .sorted(Comparator.comparing(Task::getDueDate).reversed())
                    .map(Task::getTaskDto)
                    .collect(Collectors.toList());
        }
        throw new EntityNotFoundException("User not found");
    }

    @Override
    public TaskDto updateTask(Long id, String status) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if(optionalTask.isPresent()){
            Task existingTask = optionalTask.get();
            existingTask.setTaskStatus(mapStringToTaskStatus(status));
            return taskRepository.save(existingTask).getTaskDto();
        }
        throw new EntityNotFoundException("Task not found");
    }

    @Override
    public TaskDto getTaskById(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.map(Task::getTaskDto).orElse(null);
    }

    @Override
    public CommentDTO createComment(Long taskId, String content) {
        Optional<Task> optionalTask = taskRepository.findById(taskId);
        User user = jwtUtil.getLoggedInUser();
        if((optionalTask.isPresent()) && user != null){
            Comment comment = new Comment();
            comment.setCreatedAt(new Date());
            comment.setContent(content);
            comment.setTask(optionalTask.get());
            comment.setUser(user);
            return commentRepository.save(comment).getCommentDTO();
        }
        throw new EntityNotFoundException("User or Task not found");
    }

    @Override
    public List<CommentDTO> getCommentsByTaskId(Long taskId) {
        return commentRepository.findAllByTaskId(taskId).stream().map(Comment::getCommentDTO).collect(Collectors.toList());
    }

    private TaskStatus mapStringToTaskStatus(String status) {
        return switch (status) {
            case "PENDING" -> TaskStatus.PENDING;
            case "INPROGRESS" -> TaskStatus.INPROGRESS;
            case "COMPLETED" -> TaskStatus.COMPLETED;
            case "DEFERRED" -> TaskStatus.DEFERRED;
            default -> TaskStatus.CANCELLED;

        };

    }

}
