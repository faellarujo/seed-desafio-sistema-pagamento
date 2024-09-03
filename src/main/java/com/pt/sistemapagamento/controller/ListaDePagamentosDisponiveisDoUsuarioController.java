package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import com.pt.sistemapagamento.request.ListaDePagamentosDoUsuarioRequest;
import com.pt.sistemapagamento.response.ListaDePagamentoResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ListaDePagamentosDisponiveisDoUsuarioController {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Criação do ambiente necessário para listar pagamentos de um determinado usuário para um determinado restaurante
     */

    @GetMapping("/ListaDePagamentos")
    public ResponseEntity<List<ListaDePagamentoResponse>> listarPagamentos(@RequestBody @Valid ListaDePagamentosDoUsuarioRequest usuarioRequest) {
        final FormaDePagamentoModel formaDePagamentoModel = new FormaDePagamentoModel();
        final List<FormaDePagamentoModel> listaDePagamentosDisponiveis = formaDePagamentoModel.getListaDePagamentoDisponivel(usuarioRequest.getId_Usuario(), usuarioRequest.getId_Restaurante(), entityManager);
        final List<ListaDePagamentoResponse> collect = listaDePagamentosDisponiveis.stream().map(formaDePagamentoModel1 -> new ListaDePagamentoResponse(formaDePagamentoModel1.getDescricao(), formaDePagamentoModel1.getId())).collect(Collectors.toList());
        return ResponseEntity.ok(collect);
    }
}