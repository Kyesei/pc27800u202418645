package com.andeslogistics.platform.u202418645.interfaces.rest;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import java.util.Map;
import java.util.Locale;

@RestControllerAdvice
public class DeliveryOrderExceptionHandler {

    private boolean spanish() {
        return LocaleContextHolder.getLocale().getLanguage().equals("es");
    }

    private ResponseEntity<Map<String, String>> response(HttpStatus status, String message) {
        return ResponseEntity.status(status).body(Map.of("message", message));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> validation(MethodArgumentNotValidException ex) {
        String field = ex.getBindingResult().getFieldErrors().isEmpty()
            ? "request"
            : ex.getBindingResult().getFieldErrors().get(0).getField();

        return response(HttpStatus.BAD_REQUEST,
            spanish() ? "Campo inválido: " + field : "Invalid field: " + field);
    }

    @ExceptionHandler({IllegalArgumentException.class, HttpMessageNotReadableException.class})
    public ResponseEntity<Map<String, String>> badRequest(Exception ex) {
        return response(HttpStatus.BAD_REQUEST,
            spanish() ? "Solicitud inválida" : "Invalid request");
    }

    @ExceptionHandler({DuplicateKeyException.class, DataIntegrityViolationException.class})
    public ResponseEntity<Map<String, String>> conflict(Exception ex) {
        return response(HttpStatus.CONFLICT,
            spanish() ? "El código de entrega ya existe" : "Delivery code already exists");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> unexpected(Exception ex) {
        return response(HttpStatus.INTERNAL_SERVER_ERROR,
            spanish() ? "Error interno del servidor" : "Internal server error");
    }
}