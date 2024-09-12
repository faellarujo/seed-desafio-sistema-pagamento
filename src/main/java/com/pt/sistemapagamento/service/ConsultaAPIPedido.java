package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.model.PedidoModel;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsultaAPIPedido {

    public PedidoModel getPedido(Long idPedido) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/api/pedidos/" + idPedido;
        return restTemplate.getForObject(uri, PedidoModel.class);
    }
}