package com.inditex.proof.pacman.catalog.service.rest.exception;

import java.util.stream.Collectors;

import com.inditex.proof.pacman.catalog.service.application.exception.FilterProductQueryException;
import com.inditex.proof.pacman.catalog.service.domain.exceptions.ProductDomainException;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Slf4j
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ProductDomainException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO hadleException(ProductDomainException productDomainException) {
        log.error(productDomainException.getMessage(), productDomainException);
        return ErrorDTO.builder()
                       .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                       .message(productDomainException.getMessage())
                       .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {FilterProductQueryException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO hadleException(FilterProductQueryException filterProductQueryException) {
        log.error(filterProductQueryException.getMessage(), filterProductQueryException);
        return ErrorDTO.builder()
                       .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                       .message(filterProductQueryException.getMessage())
                       .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorDTO hadleException(Exception exception) {
        log.error(exception.getMessage(), exception);
        return ErrorDTO.builder()
                       .code(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                       .message("Unexpected error!")
                       .build();
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(value = {ValidationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorDTO hadleException(ValidationException validationException) {
        ErrorDTO errorDTO;
        if (validationException instanceof ConstraintViolationException) {
            String errorMessages = ((ConstraintViolationException) validationException).getConstraintViolations()
                                                                                       .stream()
                                                                                       .map(ConstraintViolation::getMessage)
                                                                                       .collect(Collectors.joining("--"));
            log.error(errorMessages, validationException);
            errorDTO = ErrorDTO.builder()
                               .code(HttpStatus.BAD_REQUEST.getReasonPhrase())
                               .message(errorMessages)
                               .build();
        } else {
            String exceptionMessage = validationException.getMessage();
            log.error(exceptionMessage, validationException);
            errorDTO = ErrorDTO.builder()
                               .code(HttpStatus.BAD_GATEWAY.getReasonPhrase())
                               .message(exceptionMessage)
                               .build();
        }
        return errorDTO;
    }

}
