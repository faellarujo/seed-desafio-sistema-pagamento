package com.pt.sistemapagamento.exception;

public class FormaDePagamentoNaoOffline extends RuntimeException {
    public FormaDePagamentoNaoOffline(String message) {
        super(message);
    }
}
