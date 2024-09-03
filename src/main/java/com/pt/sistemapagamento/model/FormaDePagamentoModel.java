package com.pt.sistemapagamento.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

import java.util.List;

@Entity
@Table(name = "forma_de_pagamento")
public class FormaDePagamentoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuarioModel;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private RestauranteModel restauranteModel;

    @Enumerated(jakarta.persistence.EnumType.STRING)
    @NotNull
    private TipoDePagamentoModel tipo;

    @Column(name = "pagamentoOnline", nullable = false)
    private boolean pagamentoOnline;


    @Column(name = "descricao", nullable = false)
    private String descricao;


    @Deprecated
    public FormaDePagamentoModel() {

    }


    public FormaDePagamentoModel(TipoDePagamentoModel tipo, boolean pagamentoOnline, String descricao) {
        this.tipo = tipo;
        this.pagamentoOnline = pagamentoOnline;
        this.descricao = descricao;

    }

    public Long getId() {
        return id;
    }

    public TipoDePagamentoModel getTipo() {
        return tipo;
    }

    public void setTipo(TipoDePagamentoModel tipo) {
        this.tipo = tipo;
        this.pagamentoOnline = tipo == TipoDePagamentoModel.CARTAO;
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

    @Override
    public String toString() {
        return "FormaDePagamentoModel{" +
                "tipo=" + tipo +
                ", pagamentoOnline=" + pagamentoOnline +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    public List<FormaDePagamentoModel> getListaDePagamentoDisponivel(Long id_usuario, Long  id_restaurante, EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT f FROM FormaDePagamentoModel f WHERE f.usuarioModel.id = :id_usuario AND f.restauranteModel.id = :id_restaurante");
        query.setParameter("id_usuario", id_usuario);
        query.setParameter("id_restaurante", id_restaurante);
        List<FormaDePagamentoModel> formaDePagamentoModel = query.getResultList();
        return formaDePagamentoModel;
    }
}