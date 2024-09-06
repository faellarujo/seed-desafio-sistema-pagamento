package com.pt.sistemapagamento.controller;


import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RealizarPedidoOfflineController {

    @GetMapping("/RealizarPedidoOffline")
    public String realizarPedidoOffline(@RequestBody RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {
        return realizarPedidoOfflineRequest.toString();
    }
}
