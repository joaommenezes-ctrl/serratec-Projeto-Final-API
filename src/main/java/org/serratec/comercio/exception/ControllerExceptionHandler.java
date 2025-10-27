package org.serratec.comercio.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ EmailException.class, SenhaException.class })
	protected ResponseEntity<Object> handleBusinessException(RuntimeException ex) {
		return ResponseEntity.unprocessableEntity().body(ex.getMessage());
	}

	@ExceptionHandler(RecursoNaoEncontradoException.class)
	protected ResponseEntity<Object> handleResourceNotFoundException(RecursoNaoEncontradoException ex) {
		ErroResposta erroResposta = new ErroResposta(HttpStatusCode.valueOf(404).value(), ex.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(404).body(erroResposta);
	}

	@ExceptionHandler(ClienteNaoAutorizadoException.class)
	protected ResponseEntity<Object> handleClienteNaoAutorizadoException(ClienteNaoAutorizadoException ex) {
		ErroResposta erroResposta = new ErroResposta(HttpStatusCode.valueOf(404).value(), ex.getMessage(), LocalDateTime.now());
		return ResponseEntity.status(403).body(erroResposta);
	}
}
