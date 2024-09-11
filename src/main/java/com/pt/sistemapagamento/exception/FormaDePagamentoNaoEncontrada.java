package com.pt.sistemapagamento.exception;

public class FormaDePagamentoNaoEncontrada extends RuntimeException {
    public FormaDePagamentoNaoEncontrada(String message) {
        super(message);
    }
}
