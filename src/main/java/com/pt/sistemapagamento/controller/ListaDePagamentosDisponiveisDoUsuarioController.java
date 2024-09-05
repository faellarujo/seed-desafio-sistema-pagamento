package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import com.pt.sistemapagamento.model.PossiveisFraudadores;
import com.pt.sistemapagamento.model.UsuarioModel;
import com.pt.sistemapagamento.repository.PossiveisFraudadoresrepository;
import com.pt.sistemapagamento.request.ListaDePagamentosDoUsuarioRequest;
import com.pt.sistemapagamento.response.ListaDePagamentoResponse;
import com.pt.sistemapagamento.service.AntiFraudeService;
import com.pt.sistemapagamento.service.FormaDePagamentoService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private PossiveisFraudadoresrepository possiveisFraudadoresrepository; //1

    @Autowired
    private FormaDePagamentoService formaDePagamentoService; //1

    @Autowired
    private AntiFraudeService antiFraudeService; //1

    /**
     * Criação do ambiente necessário para listar pagamentos de um determinado usuário para um determinado restaurante
     */

    @GetMapping("/ListaDePagamentos")
    public ResponseEntity<List<ListaDePagamentoResponse>> listarPagamentos(@RequestBody @Valid ListaDePagamentosDoUsuarioRequest usuarioRequest) {


        // Recupera a lista de possíveis fraudadores
        List<PossiveisFraudadores> possiveisFraudadores = possiveisFraudadoresrepository.findAll(); //1


        // Recupera o usuário
        final UsuarioModel usuario = entityManager.find(UsuarioModel.class, usuarioRequest.getId_Usuario()); //1


        // verifica fraude
        if(antiFraudeService.antiFraude(usuario, possiveisFraudadores)){ //1
            final List<FormaDePagamentoModel> listaDePagamentosDisponiveis = formaDePagamentoService.getListaDePagamentoDisponivelParaFraudadores(usuarioRequest.getId_Usuario(), usuarioRequest.getId_Restaurante(), entityManager);
            final List<ListaDePagamentoResponse> collect = listaDePagamentosDisponiveis.stream().map(formaDePagamentoModel1 -> new ListaDePagamentoResponse(formaDePagamentoModel1.getDescricao(), formaDePagamentoModel1.getId())).collect(Collectors.toList());
            return ResponseEntity.ok(collect);
        } else { //1
            final List<FormaDePagamentoModel> listaDePagamentosDisponiveis = formaDePagamentoService.getListaDePagamentoDisponivel(usuarioRequest.getId_Usuario(), usuarioRequest.getId_Restaurante(), entityManager);
            final List<ListaDePagamentoResponse> collect = listaDePagamentosDisponiveis.stream().map(formaDePagamentoModel1 -> new ListaDePagamentoResponse(formaDePagamentoModel1.getDescricao(), formaDePagamentoModel1.getId())).collect(Collectors.toList());
            return ResponseEntity.ok(collect);
        }
    }
}