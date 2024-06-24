package br.com.stockhub.stockhub.exception.response;

import java.time.LocalDateTime;

public record ExceptionResponse(LocalDateTime timestamp, String message, String details) {

}
