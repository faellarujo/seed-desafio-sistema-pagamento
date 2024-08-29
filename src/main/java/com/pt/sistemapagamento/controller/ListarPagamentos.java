package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.request.UsuarioRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ListarPagamentos {

    /**
     * Criação do ambiente necessário para listar pagamentos de um determinado usuário para um determinado restaurante     */



    @GetMapping("/pagamentos")
    public String listarPagamentos(@RequestBody @Valid UsuarioRequest usuarioRequest) {
        return usuarioRequest.toString();
    }
}
