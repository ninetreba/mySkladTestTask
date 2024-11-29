package com.example.myskladtesttask.controller;

import com.example.myskladtesttask.exception.BusinessRuntimeException;
import com.example.myskladtesttask.exception.ErrorCodeEnum;
import com.example.myskladtesttask.model.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestControllerErrorHandler {

    @ExceptionHandler(BusinessRuntimeException.class)
    public ResponseEntity<ErrorDto> handleBusinessException(BusinessRuntimeException ex){
        ErrorDto errorDto = new ErrorDto(ex.getErrorCodeEnum().getCode(), ex.getMessage());
        return new ResponseEntity<>(errorDto, ex.getErrorCode().getHttpStatus());
    }


    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Throwable.class)
    public ErrorDto handleAllException(Throwable ex){
        return new ErrorDto(ErrorCodeEnum.INTERNAL_SERVER_ERROR.getCode(), ex.getMessage());
    }




}