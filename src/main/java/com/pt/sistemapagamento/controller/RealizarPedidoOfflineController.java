package com.pt.sistemapagamento.controller;

import com.pt.sistemapagamento.exception.*;
import com.pt.sistemapagamento.model.*;
import com.pt.sistemapagamento.repository.FormaDePagamentoRepository;
import com.pt.sistemapagamento.repository.PedidoRepository;
import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import com.pt.sistemapagamento.service.ConsultaAPIPedido;
import com.pt.sistemapagamento.service.RestauranteService;
import com.pt.sistemapagamento.service.UsuarioService;
import com.pt.sistemapagamento.util.StatusPagamento;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class RealizarPedidoOfflineController {

    @Autowired
    private ConsultaAPIPedido consultaAPIPedido;

    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private RestauranteService restauranteService;

    @Autowired
    private PedidoRepository pedidoRepository;


    @GetMapping("/RealizarPedidoOffline")
    public PedidoModel realizarPedidoOffline(@RequestBody @Valid RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {

        // verifica existencia de um usuário

        final UsuarioModel usuario = usuarioService.verificaExistenciaDoUsuario(realizarPedidoOfflineRequest);


        // verifica existencia de um restaurante

        final RestauranteModel restauranteModel = restauranteService.verificaExistenciaDoRestaurante(realizarPedidoOfflineRequest);


        PedidoModel pedido = consultaAPIPedido.getPedido(realizarPedidoOfflineRequest.getId_Pedido());
        Optional.ofNullable(pedido).orElseThrow(() -> new PedidoNaoEncontradoNaAPIException("Pedido não encontrado"));


        // O método findById retorna um Optional<FormaDePagamentoModel>

        Optional<FormaDePagamentoModel> repositoryById = formaDePagamentoRepository.findById(realizarPedidoOfflineRequest.getID_formaDePagamentoOffline());
        Optional.ofNullable(repositoryById).orElseThrow(() -> new FormaDePagamentoNaoEncontrada("Forma de pagamento não encontrada"));

        if (repositoryById.isEmpty()) {
            throw new FormaDePagamentoNaoEncontrada("Forma de pagamento com ID: " + realizarPedidoOfflineRequest.getID_formaDePagamentoOffline() + " não encontrada: ");
        }

        // verifica se a forma de pagamento é offoffline

        final String pagamentooffiline = repositoryById.get().getPagamentoOnline();
        if (pagamentooffiline.equals("FALSE")) {
            final PedidoModel realizarPedidoOfflineRequestModel = realizarPedidoOfflineRequest.toModel(realizarPedidoOfflineRequest, pedido.getValor());
            pedido.setStatusPagamento(StatusPagamento.AGUARDANDO_PAGAMENTO);
            pedidoRepository.save(realizarPedidoOfflineRequestModel);
            return realizarPedidoOfflineRequestModel;
        };

        // se não for offline, retorna uma exceção
        throw new FormaDePagamentoNaoOffline("Forma de pagamento não é offline");
    }


}
