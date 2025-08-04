package com.schedulemanagerapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CommentRequest {
    private String content;
    private String author;
    private String password;
}
