package com.pt.sistemapagamento.response;

public class ListaDePagamentoResponse {

    private String descricao;

    private Long id_FomaDePagamento;


    // getters and setters

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId_FomaDePagamento() {
        return id_FomaDePagamento;
    }

    public void setId_FomaDePagamento(Long id_FomaDePagamento) {
        this.id_FomaDePagamento = id_FomaDePagamento;
    }

    // constructors

    public ListaDePagamentoResponse() {
    }

    public ListaDePagamentoResponse(String descricao, Long id_FomaDePagamento) {
        this.descricao = descricao;
        this.id_FomaDePagamento = id_FomaDePagamento;
    }

    // toString

    @Override
    public String toString() {
        return "ListaDePagamentoResponse{" +
                "descricao='" + descricao + '\'' +
                ", id_FomaDePagamento=" + id_FomaDePagamento +
                '}';
    }
}
