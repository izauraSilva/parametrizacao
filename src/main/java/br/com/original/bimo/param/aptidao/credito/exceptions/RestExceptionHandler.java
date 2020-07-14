package br.com.original.bimo.param.aptidao.credito.exceptions;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.original.bimo.param.aptidao.credito.model.Error;
import br.com.original.bimo.param.aptidao.credito.model.ErrorDetails;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        List<ErrorDetails> errors = getErrors(ex);
        Error errorResponse = getErrorResponse(status, errors);
        return new ResponseEntity<>(errorResponse, status);
    }

    private Error getErrorResponse(HttpStatus status, List<ErrorDetails> errors) {
        return new Error(LocalDateTime.now(), status.value(), status.name(), null, null, null, errors);
    }

    private List<ErrorDetails> getErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors().stream()
                .map(error -> new ErrorDetails(error.getDefaultMessage(), error.getField()))
                .collect(Collectors.toList());
    }

}
