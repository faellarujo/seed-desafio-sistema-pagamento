package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import com.pt.sistemapagamento.model.Pedido;
import com.pt.sistemapagamento.repository.FormaDePagamentoRepository;
import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import com.pt.sistemapagamento.service.ConsultaAPIPedido;
import com.pt.sistemapagamento.service.PagamentoOffline;
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
    private PagamentoOffline pagamentoOffilne;


    @Autowired
    private FormaDePagamentoRepository formaDePagamentoRepository;

    @GetMapping("/RealizarPedidoOffline")
    public Pedido realizarPedidoOffline(@RequestBody RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {
        Pedido pedido = consultaAPIPedido.getPedido(realizarPedidoOfflineRequest.getId_Pedido());


        // O método findById retorna um Optional<FormaDePagamentoModel>
        final Optional<FormaDePagamentoModel> repositoryById = formaDePagamentoRepository.findById(realizarPedidoOfflineRequest.getID_formaDePagamentoOffline());


        // verifica se a forma de pagamento é offoffline

        final String pagamentooffiline = repositoryById.get().getPagamentoOnline();
        if (pagamentooffiline.equals("FALSE")) {
            final Pedido realizarPedidoOfflineRequestModel = realizarPedidoOfflineRequest.toModel(realizarPedidoOfflineRequest, pedido.getValor());
            return realizarPedidoOfflineRequestModel;
        };
        return pedido;
    }
}
