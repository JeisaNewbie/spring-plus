package org.example.expert.domain.todo.repository;

import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.JPAExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.example.expert.domain.common.dto.TimeRange;
import org.example.expert.domain.todo.dto.response.TodoSearchResponseDto;
import org.example.expert.domain.todo.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static org.example.expert.domain.comment.entity.QComment.comment;
import static org.example.expert.domain.manager.entity.QManager.manager;
import static org.example.expert.domain.todo.entity.QTodo.todo;

@RequiredArgsConstructor
public class ToDoRepositoryQueryImpl implements ToDoRepositoryQuery {
    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public Optional<Todo> findByIdWithUser(Long todoId) {
        return Optional.ofNullable(jpaQueryFactory.select(todo)
                .from(todo)
                .leftJoin(todo.user)
                .fetchJoin()
                .where(todo.id.eq(todoId))
                .fetchOne());
    }

    @Override
    public List<TodoSearchResponseDto> findAllByTitleAndNicknameAndDate(String title, String nickname, TimeRange timeRange, Pageable pageable) {
        return jpaQueryFactory.select(
                Projections.fields(
                        TodoSearchResponseDto.class,
                        todo.id.as("todoId"),
                        todo.title,
                        todo.user.nickname,
                        Expressions.as(
                                JPAExpressions
                                        .select(comment.count())
                                        .from(comment)
                                        .where(comment.todo.eq(todo)), "commentCount"
                        ),
                        Expressions.as(
                                JPAExpressions
                                        .select(manager.count())
                                        .from(manager)
                                        .where(manager.todo.eq(todo)), "managerCount"
                        ),
                        todo.createdAt
                        ))
                .from(todo)
                .leftJoin(todo.user)
                .where(
                        TodoTitleEq(title),
                        UserNicknameEq(nickname),
                        CreatedAtBetween(timeRange)
                        )
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();
    }

    private static BooleanExpression TodoTitleEq(String title) {
        return Objects.nonNull(title) ? todo.title.eq(title) : Expressions.TRUE;
    }

    private static BooleanExpression UserNicknameEq(String nickname) {
        return Objects.nonNull(nickname) ? todo.user.nickname.eq(nickname) : Expressions.TRUE;
    }

    private static BooleanExpression CreatedAtBetween(TimeRange timeRange) {
        return todo.createdAt.between(timeRange.getStartedAtWithTime(), timeRange.getEndedAtWithTime());
    }
}
