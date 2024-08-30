package com.pt.sistemapagamento.request;

import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public class UsuarioRequest {


    @Email
    @NotEmpty
    String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Deprecated
    public UsuarioRequest() {
    }

    public UsuarioRequest(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "UsuarioRequest{" +
                "email='" + email + '\'' +
                '}';
    }

}
