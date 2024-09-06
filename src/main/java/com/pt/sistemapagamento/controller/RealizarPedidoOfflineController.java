package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.model.Pedido;
import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import com.pt.sistemapagamento.service.ConsultaAPIPedido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealizarPedidoOfflineController {


    @Autowired
    private ConsultaAPIPedido consultaAPIPedido;

    @GetMapping("/RealizarPedidoOffline")
    public ResponseEntity<Pedido> realizarPedidoOffline(@RequestBody RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {

        Pedido pedido = consultaAPIPedido.realizarPedidoOffline(realizarPedidoOfflineRequest.getId_Pedido());
        return ResponseEntity.ok(pedido);
    }
}
