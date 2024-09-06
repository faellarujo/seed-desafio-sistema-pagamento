package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.model.Pedido;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class ConsultaAPIPedido {

    public Pedido realizarPedidoOffline(Long id_pedido) {
        RestTemplate restTemplate = new RestTemplate();
        String uri = "http://localhost:8080/api/pedidos/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        Pedido pedido = new Pedido(1L, new BigDecimal("100.00"));

        HttpEntity<Pedido> request = new HttpEntity<>(pedido, headers);

        Pedido response = restTemplate.postForObject(uri, request, Pedido.class);


//        ResponseEntity<Pedido> response = restTemplate.postForObject(uri, request, Pedido.class); //restTemplate.getForObject(uri + id_pedido, ResponseEntity.class);
//        if (response.getStatusCode() == HttpStatus.OK) {
//            pedido.setId(response.getBody().getId());
//            pedido.setValor(response.getBody().getValor());
//            return pedido;
//        } else {
//            return null;
//        }
        return pedido;
    }


//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.MediaType;
//import org.springframework.web.client.RestTemplate;
//
//    public class PedidoClient {
//
//        public static void main(String[] args) {
//            RestTemplate restTemplate = new RestTemplate();
//            String url = "http://localhost:8080/pedidos";
//
//            HttpHeaders headers = new HttpHeaders();
//            headers.setContentType(MediaType.APPLICATION_JSON);
//
//            Pedido pedido = new Pedido(1L, new BigDecimal("100.00"));
//            HttpEntity<Pedido> request = new HttpEntity<>(pedido, headers);
//
//            String response = restTemplate.postForObject(url, request, String.class);
//            System.out.println(response);
//        }
//    }

}