package com.pt.sistemapagamento.service;

import org.springframework.stereotype.Component;

@Component
public class PagamentoOffline {

    public static boolean pagamentoOffLine(boolean tipoPagamento) {
        return tipoPagamento;
    }
}