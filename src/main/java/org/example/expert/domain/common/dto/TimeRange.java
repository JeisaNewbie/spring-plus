package org.example.expert.domain.common.dto;

import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
public class TimeRange {
    private final LocalDateTime startedAtWithTime;
    private final LocalDateTime endedAtWithTime;

    private TimeRange(LocalDateTime startedAtWithTime, LocalDateTime endedAtWithTime) {
        this.startedAtWithTime = startedAtWithTime;
        this.endedAtWithTime = endedAtWithTime;
    }

    public static TimeRange of(LocalDate startedAt, LocalDate endedAt) {
        LocalDateTime startedAtWithTime = startedAt != null ? LocalDateTime.of(startedAt, LocalTime.MIN)
                : LocalDateTime.of(1900, 1, 1, 0, 0);;
        LocalDateTime endedAtWithTime = endedAt != null ? LocalDateTime.of(endedAt, LocalTime.MAX)
                : LocalDateTime.of(9999,12,31, 23, 59, 59);
        return new TimeRange(startedAtWithTime, endedAtWithTime);
    }
}
