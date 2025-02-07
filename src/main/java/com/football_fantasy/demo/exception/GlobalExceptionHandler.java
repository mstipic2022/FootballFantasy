package com.football_fantasy.demo.exception;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(org.springframework.dao.OptimisticLockingFailureException.class)
    public ResponseEntity<String> handleOptimisticLockingFailure(Exception e) {
        logger.error("Optimistic Locking Failure: {}", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body("Optimistic Locking Conflict - Someone else has updated this record.");
    }
}

