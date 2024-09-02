package com.pt.sistemapagamento.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.validation.constraints.NotNull;

public class ListaDePagamentosDoUsuarioRequest {


    @JsonProperty("Id_Usuario")
    private Long Id_Usuario;


    @JsonProperty("Id_Restaurante")
    private Long Id_Restaurante;

    public Long getId_Usuario() {
        return Id_Usuario;
    }

    public Long getId_Restaurante() {
        return Id_Restaurante;
    }

    public void setId_Usuario(Long Id_Usuario) {
        this.Id_Usuario = Id_Usuario;
    }

    public void setId_Restaurante(Long Id_Restaurante) {
        this.Id_Restaurante = Id_Restaurante;
    }

    public ListaDePagamentosDoUsuarioRequest() {
    }

    public ListaDePagamentosDoUsuarioRequest(Long id_Restaurante, Long id_Usuario) {
        Id_Restaurante = id_Restaurante;
        Id_Usuario = id_Usuario;
    }

    @Override
    public String toString() {
        return "ListaDePagamentosDoUsuarioRequest{" +
                "Id_Usuario=" + Id_Usuario +
                ", Id_Restaurante=" + Id_Restaurante +
                '}';
    }
}