package com.ms.parkingcontrol.adapters.config;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

        List<ErrorObject> errors = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorObject(error.getDefaultMessage(), error.getField(), error.getRejectedValue()))
                .collect(Collectors.toList());

        ErrorResponse errorResponse = new ErrorResponse("Request has invalid fields",
                HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.getReasonPhrase(), ex.getBindingResult().getObjectName(), errors);

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ConflictParkingSpotException.class})
    protected ResponseEntity<Object> handleConflictParkingSpot(ConflictParkingSpotException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.CONFLICT.value(), HttpStatus.CONFLICT.name());

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

    @ExceptionHandler({ParkingSpotNotFoundException.class})
    protected ResponseEntity<ErrorResponse> handleParkingSpotNotFound(ParkingSpotNotFoundException ex) {

        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), HttpStatus.NOT_FOUND.value(), HttpStatus.NOT_FOUND.name());

        log.error(ExceptionUtils.getStackTrace(ex));

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
