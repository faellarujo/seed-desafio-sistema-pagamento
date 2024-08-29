package com.pt.sistemapagamento.model;

public class FormaDePagamento {


    private TipoDePagamento tipo;
    private boolean pagamentoOnline;
    private String descricao;

    public FormaDePagamento(TipoDePagamento tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.pagamentoOnline = tipo == TipoDePagamento.CARTAO;
    }

    public TipoDePagamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePagamento tipo) {
        this.tipo = tipo;
        this.pagamentoOnline = tipo == TipoDePagamento.CARTAO;
    }

    public boolean isPagamentoOnline() {
        return pagamentoOnline;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}