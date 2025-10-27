package org.serratec.comercio.domain;

import org.serratec.comercio.exception.EnumValidationException;

public enum StatusPedido {
	
	PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE, CANCELADO, DEVOLVIDO;

	public static StatusPedido fromString(String value) throws EnumValidationException {
		try {
			return StatusPedido.valueOf(value.toUpperCase());
		} catch (IllegalArgumentException | NullPointerException e) {
			throw new EnumValidationException("StatusPedido inválido: " + value
					+ ". Valores permitidos: PENDENTE, PROCESSANDO, ENVIADO, ENTREGUE, CANCELADO, DEVOLVIDO.");
		}
	}
}
