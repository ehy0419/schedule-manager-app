package com.schedulemanagerapp.service;

import com.schedulemanagerapp.dto.CommentRequest;
import com.schedulemanagerapp.dto.CommentResponse;
import com.schedulemanagerapp.entity.Comment;
import com.schedulemanagerapp.entity.Schedule;
import com.schedulemanagerapp.repository.CommentRepository;
import com.schedulemanagerapp.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;
    private final ScheduleRepository scheduleRepository;

    @Transactional
    public CommentResponse createComment(Long scheduleId, CommentRequest request) {
        Schedule schedule = scheduleRepository.findById(scheduleId)
                .orElseThrow(() -> new IllegalArgumentException("일정이 존재하지 않습니다."));

        if (commentRepository.countByScheduleId(scheduleId) >= 10) {
            throw new IllegalStateException("댓글은 최대 10개까지 작성 가능합니다.");
        }

        Comment comment = new Comment(request.getContent(), request.getAuthor(), request.getPassword(), schedule);
        Comment saved = commentRepository.save(comment);
        return new CommentResponse(saved);
    }

}
