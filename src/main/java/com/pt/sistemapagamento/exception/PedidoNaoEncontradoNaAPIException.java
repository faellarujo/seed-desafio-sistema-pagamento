package com.pt.sistemapagamento.exception;

public class PedidoNaoEncontradoNaAPIException extends RuntimeException {
    public PedidoNaoEncontradoNaAPIException(String message) {
        super(message);
    }
}
