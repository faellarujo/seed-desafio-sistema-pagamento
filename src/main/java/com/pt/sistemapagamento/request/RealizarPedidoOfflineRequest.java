package com.pt.sistemapagamento.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.pt.sistemapagamento.model.Pedido;
import com.pt.sistemapagamento.util.StatusPagamento;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class RealizarPedidoOfflineRequest {


    @NotNull
    @JsonProperty("ID_formaDePagamentoOffline")
    private Long ID_formaDePagamentoOffline;

    @NotNull
    @JsonProperty("Id_Restaurente")
    private Long Id_Restaurente;

    @NotNull
    @JsonProperty("Id_Pedido")
    private Long Id_Pedido;

    @NotNull
    @JsonProperty("Id_Usuario")
    private Long Id_Usuario;

    // Construtor

    @Deprecated
    public RealizarPedidoOfflineRequest() {
    }

    // Construtor com parâmetros e as anotações

    public RealizarPedidoOfflineRequest(@NotNull Long ID_formaDePagamentoOffline, @NotNull Long id_Restaurente, @NotNull Long id_Pedido, @NotNull Long id_Usuario) {
        this.ID_formaDePagamentoOffline = ID_formaDePagamentoOffline;
        Id_Restaurente = id_Restaurente;
        Id_Pedido = id_Pedido;
        Id_Usuario = id_Usuario;
    }

    // Getters e Setters

    public Long getID_formaDePagamentoOffline() {
        return ID_formaDePagamentoOffline;
    }

    public void setID_formaDePagamentoOffline(Long ID_formaDePagamentoOffline) {
        this.ID_formaDePagamentoOffline = ID_formaDePagamentoOffline;
    }

    public Long getId_Restaurente() {
        return Id_Restaurente;
    }

    public void setId_Restaurente(Long id_Restaurente) {
        Id_Restaurente = id_Restaurente;
    }

    public Long getId_Pedido() {
        return Id_Pedido;
    }

    public void setId_Pedido(Long id_Pedido) {
        Id_Pedido = id_Pedido;
    }

    public Long getId_Usuario() {
        return Id_Usuario;
    }

    public void setId_Usuario(Long id_Usuario) {
        Id_Usuario = id_Usuario;
    }

    // toString

    @Override
    public String toString() {
        return "RealizarPedidoOffline{" +
                "ID_formaDePagamentoOffline=" + ID_formaDePagamentoOffline +
                ", Id_Restaurente=" + Id_Restaurente +
                ", Id_Pedido=" + Id_Pedido +
                ", Id_Usuario=" + Id_Usuario +
                '}';
    }

    public Pedido toModel(RealizarPedidoOfflineRequest realizarPedidoOfflineRequest, BigDecimal valor) {
            return new Pedido(realizarPedidoOfflineRequest.getId_Pedido(),
                    valor,
                    realizarPedidoOfflineRequest.getId_Usuario(),
                    StatusPagamento.AGUARDANDO_PAGAMENTO,
                    LocalDateTime.now(),
                    "Pedido Offline");
    }
}
