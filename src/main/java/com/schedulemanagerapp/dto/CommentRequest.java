package com.schedulemanagerapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * CommentRequest
 * -------------------
 * 댓글 생성 요청 DTO.
 */

@Getter
@NoArgsConstructor
public class CommentRequest {
    private String content;         // 내용(필수, 최대 100자)
    private String author;          // 작성자명(필수)
    private String password;        // 비밀번호(필수, 추후 수정/삭제 검증용)
}

/// request와 response 에서 기본생성자가 유무의 차이 이유 알기
/// reflection에 대해서 알기
/// 더티체킹