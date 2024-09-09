package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.model.Pedido;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class ConsultaAPIPedido {

    public Pedido getPedido(Long idPedido) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/api/pedidos/" + idPedido;

        Pedido pedido = restTemplate.getForObject(uri, Pedido.class);
        return pedido;
    }
}