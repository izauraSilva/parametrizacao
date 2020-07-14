package br.com.original.bimo.param.aptidao.credito.exceptions;

import br.com.original.bimo.param.aptidao.credito.model.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CodeCnaeRegexException.class)
    public ResponseEntity<Error> customHandleNotFound(Exception ex) {

        Error errors = new Error();
        errors.setTimestamp(LocalDateTime.now());
        errors.setErro(ex.getMessage());
        errors.setStatus(HttpStatus.BAD_REQUEST.value());

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }
}
