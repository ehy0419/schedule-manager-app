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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime scheduleTime;

    public Schedule(String title, String description, LocalDateTime scheduleTime) {
        this.title = title;
        this.description = description;
        this.scheduleTime = scheduleTime;
    }

    public void update(String title, String description, LocalDateTime scheduleTime) {
        this.title = title;
        this.description = description;
        this.scheduleTime = scheduleTime;
    }

}
