package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import com.pt.sistemapagamento.request.ListaDePagamentosDoUsuarioRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListaDePagamentosDisponiveisDoUsuarioController {


    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Criação do ambiente necessário para listar pagamentos de um determinado usuário para um determinado restaurante
     *
     * */

    @GetMapping("/ListaDePagamentos")
    public String listarPagamentos(@RequestBody ListaDePagamentosDoUsuarioRequest usuarioRequest) {
        final FormaDePagamentoModel formaDePagamentoModel = new FormaDePagamentoModel();
        final List<FormaDePagamentoModel> listaDePagamentoDisponivel = formaDePagamentoModel.getListaDePagamentoDisponivel(usuarioRequest.getId_Usuario(), usuarioRequest.getId_Restaurante(), entityManager);
        return listaDePagamentoDisponivel.toString();
    }
}
