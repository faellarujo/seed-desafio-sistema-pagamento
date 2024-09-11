package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.exception.FormaDePagamentoNaoEncontrada;
import com.pt.sistemapagamento.exception.FormaDePagamentoNaoOffline;
import com.pt.sistemapagamento.exception.PedidoNaoEncontradoNaAPIException;
import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import com.pt.sistemapagamento.model.Pedido;
import com.pt.sistemapagamento.repository.FormaDePagamentoRepository;
import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import com.pt.sistemapagamento.service.ConsultaAPIPedido;
import com.pt.sistemapagamento.service.PagamentoOffline;
import jakarta.validation.Valid;
import org.apache.logging.log4j.util.Cast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Optional;

@RestController
public class RealizarPedidoOfflineController {

    @Autowired
    private ConsultaAPIPedido consultaAPIPedido;

    @Autowired
    private PagamentoOffline pagamentoOffilne;

    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    @GetMapping("/RealizarPedidoOffline")
    public Pedido realizarPedidoOffline(@RequestBody @Valid RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {

        Pedido pedido = consultaAPIPedido.getPedido(realizarPedidoOfflineRequest.getId_Pedido());
        Optional.ofNullable(pedido).orElseThrow(() -> new PedidoNaoEncontradoNaAPIException("Pedido não encontrado"));
//        if (.isEmpty()) {
//            throw new PedidoNaoEncontradoNaAPIException("Pedido não encontrado");
//        }

        // O método findById retorna um Optional<FormaDePagamentoModel>

        Optional<FormaDePagamentoModel> repositoryById = formaDePagamentoRepository.findById(realizarPedidoOfflineRequest.getID_formaDePagamentoOffline());
        Optional.ofNullable(repositoryById).orElseThrow(() -> new FormaDePagamentoNaoEncontrada("Forma de pagamento não encontrada"));

        if (repositoryById.isEmpty()) {
            throw new FormaDePagamentoNaoEncontrada("Forma de pagamento com ID: " + realizarPedidoOfflineRequest.getID_formaDePagamentoOffline() + " não encontrada: ");
        }

        // verifica se a forma de pagamento é offoffline

        final String pagamentooffiline = repositoryById.get().getPagamentoOnline();
        if (pagamentooffiline.equals("FALSE")) {
            final Pedido realizarPedidoOfflineRequestModel = realizarPedidoOfflineRequest.toModel(realizarPedidoOfflineRequest, pedido.getValor());
            return realizarPedidoOfflineRequestModel;
        };

        // se não for offline, retorna uma exceção
        throw new FormaDePagamentoNaoOffline("Forma de pagamento não é offline");
    }
}
