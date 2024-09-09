package com.pt.sistemapagamento.util;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

public class InfoAPIExterna {

    @JsonProperty
    private Long id;

    @JsonProperty("valor")
    private BigDecimal valor;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public InfoAPIExterna() {
    }

    public InfoAPIExterna(Long id, BigDecimal valor) {
        this.id = id;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "InfoAPIExterna{" +
                "id=" + id +
                ", valor=" + valor +
                '}';
    }



}
