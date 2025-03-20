package org.example.expert.domain.todo.repository;

import org.example.expert.domain.common.dto.TimeRange;
import org.example.expert.domain.todo.dto.response.TodoSearchResponseDto;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ToDoRepositoryQuery {
    Optional<Todo> findByIdWithUser(Long todoId);

    List<TodoSearchResponseDto> findAllByTitleAndNicknameAndDate(String title, String nickname, TimeRange timeRange, Pageable pageable);
}
