package org.example.expert.domain.todo.dto.response;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class TodoSearchResponseDto {
    private Long todoId;
    private String title;
    private String nickname;
    private Long managerCount;
    private Long commentCount;
    private LocalDateTime createdAt;
}
