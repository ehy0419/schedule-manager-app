package com.schedulemanagerapp.dto;

import com.schedulemanagerapp.entity.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

/**
 * CommentResponse
 * -------------------
 * 댓글 조회 응답 DTO.
 * - Entity -> DTO 변환 생성자 제공
 */

@Getter
public class CommentResponse {
    private final Long id;
    private final String content;
    private final String author;
    private final LocalDateTime createdAt;
    private final LocalDateTime modifiedAt;

    public CommentResponse(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.author = comment.getAuthor();
        this.createdAt = comment.getCreatedAt();
        this.modifiedAt = comment.getModifiedAt();
    }
}
