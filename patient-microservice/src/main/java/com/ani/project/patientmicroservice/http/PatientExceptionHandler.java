package com.ani.project.patientmicroservice.http;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class PatientExceptionHandler {

    @ExceptionHandler({Exception.class })
    public ResponseEntity<ApiError> handleConstraintViolation(Exception e) {
        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST,
                LocalDateTime.now(),
                String.valueOf(e.getCause().toString()),
                e.getMessage()
        );

        return new ResponseEntity<>(
                apiError, new HttpHeaders(), apiError.getStatus());
    }
}
