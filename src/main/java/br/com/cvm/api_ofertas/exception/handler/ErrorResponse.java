package br.com.cvm.api_ofertas.exception.handler;

import java.time.Instant;

public record ErrorResponse(int status, String message, Instant timestamp) {
}
