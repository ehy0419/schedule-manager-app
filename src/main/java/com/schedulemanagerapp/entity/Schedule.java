package com.schedulemanagerapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Schedule extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//     @Column(nullable = false, length = 30) // 제목은 필수, 최대 30자
    private String title;
//     @Column(nullable = false, length = 200) // 내용은 필수, 최대 200자
    private String description;
//    @Column(nullable = false)
    private LocalDateTime scheduleTime;

    /// 1. 오류 확인 - 생성자 없음
    ///  /** 생성자: 필수 필드 세팅 */
    public Schedule(String title, String description, LocalDateTime scheduleTime) {
        this.title = title;
        this.description = description;
        this.scheduleTime = scheduleTime;
    }

    ///  업데이트하고자 하는 필드만 업데이트 해주기
    /// /** 부분 수정 메서드(의미있는 변경 메서드 제공) */
    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateDescription(String description) {
        this.description = description;
    }

    public void updateScheduleTime(LocalDateTime scheduleTime) {
        this.scheduleTime = scheduleTime;
    }
}
