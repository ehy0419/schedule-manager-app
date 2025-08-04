package com.schedulemanagerapp.repository;

import com.schedulemanagerapp.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Long> {

    /// 레벨 5에서, 댓글 최대 10개 제한
    Long countByScheduleId(Long scheduleId);

    /// 레벨 6에서, 일정 단건 조회 시, 일정에 등록된 댓글을 포함하여 응답
    List<Comment> findByScheduleId(Long scheduleId);
}
