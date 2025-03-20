package org.example.expert.aop.service;

import lombok.RequiredArgsConstructor;
import org.example.expert.aop.entity.Log;
import org.example.expert.aop.repository.LogRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LogService {
    private final LogRepository logRepository;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void save(String message) {
        Log log = Log.of(message);

        logRepository.save(log);
    }
}
