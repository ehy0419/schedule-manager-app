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

/// request와 response 에서 기본생성자가 유무의 차이 이유 알기
/// reflection에 대해서 알기
/// 더티체킹