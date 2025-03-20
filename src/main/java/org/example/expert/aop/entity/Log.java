package org.example.expert.aop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.expert.domain.common.entity.Timestamped;

@Entity
@Getter
@NoArgsConstructor
public class Log extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String message;

    private Log(String message) {
        this.message = message;
    }

    public static Log of(String message) {
        return new Log(message);
    }
}
