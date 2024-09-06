package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.Pedido;
import com.pt.sistemapagamento.service.ConsultaAPIPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PedidoController {


    @Autowired
    private ConsultaAPIPedido consultaAPIPedido;


    @GetMapping("/api/pedidos/{idPedido}")
    public String getPedido(@PathVariable Long idPedido) {

        final Map<Long, Pedido> pedidos = geraPedidosMap();
        final Pedido pedido = pedidos.get(idPedido);
        return pedido.toString();


    }

    private static Map<Long, Pedido> geraPedidosMap() {
        Map<Long, Pedido> pedidos = new HashMap<>();

        pedidos.put(1L, new Pedido(1L, new BigDecimal(100.0)));
        pedidos.put(2L, new Pedido(2L, new BigDecimal(200.0)));
        pedidos.put(3L, new Pedido(3L, new BigDecimal(300.0)));
        pedidos.put(4L, new Pedido(4L, new BigDecimal(400.0)));
        pedidos.put(5L, new Pedido(5L, new BigDecimal(500.0)));
        return pedidos;
    }
}
