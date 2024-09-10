package com.pt.sistemapagamento.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.pt.sistemapagamento.util.StatusPagamento;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import org.springframework.lang.Nullable;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("valor")
    private BigDecimal valor;

    @JsonProperty("ID_Restaurante")
    private Long ID_Usuario;

    @Enumerated
    @JsonProperty("statusPagamento")
    private StatusPagamento statusPagamento;


    @JsonProperty("criação da transação")
    private LocalDateTime criaçãodaTransação;

    @JsonProperty("informaçõesExtras")
    private String informaçõesExtras;

    @Nullable
    @JsonProperty("formaDePagamento")
    private String formaDePagamentoOnline;


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

    public Long getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(Long ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public LocalDateTime getCriaçãodaTransação() {
        return criaçãodaTransação;
    }

    public void setCriaçãodaTransação(LocalDateTime criaçãodaTransação) {
        this.criaçãodaTransação = criaçãodaTransação;
    }

    public String getInformaçõesExtras() {
        return informaçõesExtras;
    }

    public void setInformaçõesExtras(String informaçõesExtras) {
        this.informaçõesExtras = informaçõesExtras;
    }

    public String isFormaDePagamentoOnline() {
        return formaDePagamentoOnline;
    }

    public void setFormaDePagamentoOnline(String formaDePagamentoOnline) {
        this.formaDePagamentoOnline = formaDePagamentoOnline;
    }

    // Constructors

    @Deprecated
    public Pedido() {
    }

    public Pedido(Long id, BigDecimal valor, Long ID_Usuario, StatusPagamento statusPagamento, LocalDateTime criaçãodaTransação, String informaçõesExtras, String formaDePagamentoOnline) {
        this.id = id;
        this.valor = valor;
        this.ID_Usuario = ID_Usuario;
        this.statusPagamento = statusPagamento;
        this.criaçãodaTransação = criaçãodaTransação;
        this.informaçõesExtras = informaçõesExtras;
        this.formaDePagamentoOnline = formaDePagamentoOnline;
    }

    // toString

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", valor=" + valor +
                ", ID_Usuario=" + ID_Usuario +
                ", statusPagamento=" + statusPagamento +
                ", criaçãodaTransação=" + criaçãodaTransação +
                ", informaçõesExtras='" + informaçõesExtras + '\'' +
                ", formaDePagamentoOnline='" + formaDePagamentoOnline + '\'' +
                '}';
    }
}
