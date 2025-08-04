package com.schedulemanagerapp.controller;

import com.schedulemanagerapp.dto.CommentRequest;
import com.schedulemanagerapp.dto.CommentResponse;
import com.schedulemanagerapp.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    // 레벨 5 댓글 생성 API
    @PostMapping("/schedules/{scheduleId}/comments")
    public ResponseEntity<CommentResponse> createComment(
            @PathVariable Long scheduleId,
            @RequestBody CommentRequest request
    ) {
        return ResponseEntity.ok(commentService.createComment(scheduleId, request));
    }

}
