package com.pt.sistemapagamento.model;


import jakarta.persistence.*;

import java.util.List;
import java.util.Set;


@Entity
@Table(name = "usuario")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(nullable = false)
    @OneToMany(mappedBy = "usuarioModel")
    private Set<FormaDePagamentoModel> formaDePagamentoModel;

    @Deprecated
    public UsuarioModel() {
    }

    public UsuarioModel(String email, Set<FormaDePagamentoModel> formaDePagamentoModel) {
        this.email = email;
        this.formaDePagamentoModel = formaDePagamentoModel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Set<FormaDePagamentoModel> getFormaDePagamentoModel() {
        return formaDePagamentoModel;
    }

    public void setFormaDePagamentoModel(Set<FormaDePagamentoModel> formaDePagamentoModel) {
        this.formaDePagamentoModel = formaDePagamentoModel;
    }

    @Override
    public String toString() {
        return "UsuarioModel{" +
                "email='" + email + '\'' +
                ", formaDePagamentoModel=" + formaDePagamentoModel +
                '}';
    }
}
