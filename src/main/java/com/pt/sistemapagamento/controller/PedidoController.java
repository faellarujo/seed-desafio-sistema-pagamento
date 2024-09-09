package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.Pedido;
import com.pt.sistemapagamento.service.ConsultaAPIPedido;
import com.pt.sistemapagamento.util.InfoAPIExterna;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@RestController
public class PedidoController {

    @GetMapping("/api/pedidos/{idPedido}")
    public InfoAPIExterna getPedido(@PathVariable Long idPedido) {
        final Map<Long, InfoAPIExterna> longPedidoMap = geraPedidosMap();
        // percorre o map e retorna o pedido com o id informado
        return longPedidoMap.get(idPedido);
    }

    private static Map<Long, InfoAPIExterna> geraPedidosMap() {
        Map<Long, InfoAPIExterna> pedidos = new HashMap<>();

        pedidos.put(1L, new InfoAPIExterna(1L, new BigDecimal(100.0)));
        pedidos.put(2L, new InfoAPIExterna(2L, new BigDecimal(200.0)));
        pedidos.put(3L, new InfoAPIExterna(3L, new BigDecimal(300.0)));
        pedidos.put(4L, new InfoAPIExterna(4L, new BigDecimal(400.0)));
        pedidos.put(5L, new InfoAPIExterna(5L, new BigDecimal(500.0)));
        return pedidos;
    }

}
