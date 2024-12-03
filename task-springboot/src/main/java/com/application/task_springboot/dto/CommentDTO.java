package com.application.task_springboot.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author : A.S.M.M.U.P.Adhikaram
 * @Since : 10/4/2024
 * @Time : 12:33 PM
 **/
@Data

public class CommentDTO {

    private Long id;

    private String content;

    private Date createdAt;

    private Long taskId;

    private Long userId;

    private String postedBy;
}
