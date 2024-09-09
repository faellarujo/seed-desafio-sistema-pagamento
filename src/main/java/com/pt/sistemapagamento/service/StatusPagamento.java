package com.pt.sistemapagamento.service;

public class StatusPagamento {

    public  static String verificaStatusPagamento(String statusPagamento) {

        if(statusPagamento.equals("APROVADO")) {
            return "APROVADO";
        } else if(statusPagamento.equals("REPROVADO")) {
            return "REPROVADO";
        } else if(statusPagamento.equals("PENDENTE")) {
            return "PENDENTE";
        } else {
            return "ERRO";
        }
    }
}
