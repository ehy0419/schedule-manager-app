package com.schedulemanagerapp.dto;

import com.schedulemanagerapp.entity.Comment;
import com.schedulemanagerapp.entity.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

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
    private final List<CommentResponse> comments;

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

    ///  이후 스케줄 서비스에서 생성자 변경!!


    // comments 필드를 초기화 하지 않아서 주석처리
//    public ScheduleResponse(Long id, String title, String description, LocalDateTime scheduleTime, LocalDateTime createAt, LocalDateTime modifiedAt) {
//        this.id = id;
//        this.title = title;
//        this.description = description;
//        this.scheduleTime = scheduleTime;
//        this.createAt = createAt;
//        this.modifiedAt = modifiedAt;
//    }
}
