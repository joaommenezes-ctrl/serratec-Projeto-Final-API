package org.serratec.comercio.exception;

public class ClienteNaoAutorizadoException extends RuntimeException{
    public ClienteNaoAutorizadoException(String message) {
        super(message);
    }
}
