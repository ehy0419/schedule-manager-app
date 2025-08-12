package com.schedulemanagerapp.dto;

import com.schedulemanagerapp.entity.Comment;
import com.schedulemanagerapp.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ScheduleResponse
 * -------------------
 * 일정 조회 응답 DTO.
 * - Entity를 외부로 직접 노출하지 않고, 필요한 필드만 선별하여 반환
 * - 불변(immutable)하게 설계하면 안전(여기서는 final + 생성자 초기화)
 */

@Getter
public class ScheduleResponse {

    private final Long id;
    private final String title;
    private final String description;
    private final LocalDateTime scheduleTime;

    private final LocalDateTime createAt;
    private final LocalDateTime modifiedAt;

    /// 레벨6. 일정 단건 조회 시, 해당 일정에 등록된 댓글들을 포함
    // 스케줄 엔티티와 댓글 리스트를 받아서 진행.
    private final List<CommentResponse> comments;       // comments 필드가 final 이어서 반드시 초기화!

    /// 생성자에 6개의 인수
    // 도전과제 댓글 기능 없을 때 생성자.
    public ScheduleResponse(Long id, String title, String description, LocalDateTime scheduleTime, LocalDateTime createAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.scheduleTime = scheduleTime;
        this.createAt = createAt;
        this.modifiedAt = modifiedAt;
        this.comments = new ArrayList<>();      // 댓글이 없는 경우 빈 리스트로 '초기화'
                                                // // 빈 리스트로 초기화(Null-Safety)
    }

    ///  댓글 기능을 수행하면서 2개 인자로 축소.
    public ScheduleResponse(Schedule schedule, List<Comment> commentList) {
        this.id = schedule.getId();
        this.title = schedule.getTitle();
        this.description = schedule.getDescription();
        this.scheduleTime = schedule.getScheduleTime();
        this.createAt = schedule.getCreatedAt();
        this.modifiedAt = schedule.getModifiedAt();

        ///  스트림 참조.
        // 레벨 6: 댓글 리스트를 CommentResponse로 변환
        this.comments = commentList.stream()
                .map(CommentResponse::new)
                .collect(Collectors.toList());
    }
}
