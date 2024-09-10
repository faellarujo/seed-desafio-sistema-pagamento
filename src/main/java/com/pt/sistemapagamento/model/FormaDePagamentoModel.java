package com.pt.sistemapagamento.model;

import com.pt.sistemapagamento.fraude.AntiFraude;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.apache.catalina.Manager;

import java.util.List;

@Entity
@Table(name = "forma_de_pagamento")
public class FormaDePagamentoModel{

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

    @Column(name = "PAGAMENTO_ONLINE", nullable = false)
    private String pagamentoOnline;

    @Column(name = "descricao", nullable = false)
    private String descricao;


    @Deprecated
    public FormaDePagamentoModel() {

    }


    public FormaDePagamentoModel(TipoDePagamentoModel tipo, String pagamentoOnline, String descricao) {
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
    }

    public String getPagamentoOnline() {
        return pagamentoOnline;
    }

    public void setPagamentoOnline(String pagamentoOnline) {
        this.pagamentoOnline = pagamentoOnline;
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
}
