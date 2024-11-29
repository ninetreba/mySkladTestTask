package com.example.myskladtesttask.exception;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;

@AllArgsConstructor
public enum ErrorCodeEnum {
    INTERNAL_SERVER_ERROR("Внутренняя ошибка сервиса"),
    PRODUCT_NOT_FOUND("Продукт не найден", HttpStatus.NOT_FOUND);


    private final String messageTemplate;
    private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;


    public String getMessage(Object... args) {
        return MessageFormat.format(messageTemplate, args);
    }

    ErrorCodeEnum(String messageTemplate) {
        this.messageTemplate = messageTemplate;
    }

    public String getCode() {
        return this.name();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}