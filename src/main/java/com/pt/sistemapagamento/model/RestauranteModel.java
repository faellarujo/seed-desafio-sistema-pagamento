package com.pt.sistemapagamento.model;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "restaurante")
public class RestauranteModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @OneToMany(mappedBy = "restauranteModel")
    @Column(name = "forma_de_pagamento")
    private Set<FormaDePagamentoModel> formaDePagamentoModel;

    @Deprecated
    public RestauranteModel() {
    }

    public RestauranteModel(String nome, Set<FormaDePagamentoModel> formaDePagamentoModel) {
        this.nome = nome;
        this.formaDePagamentoModel = formaDePagamentoModel;
    }

}
