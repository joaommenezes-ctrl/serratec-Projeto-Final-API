package org.serratec.comercio.exception;

public class PedidoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public PedidoNotFoundException(String message) {
        super(message);
    }
}