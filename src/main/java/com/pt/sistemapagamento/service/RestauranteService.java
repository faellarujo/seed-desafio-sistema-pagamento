package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.exception.RestauranteNaoEncontrado;
import com.pt.sistemapagamento.model.RestauranteModel;
import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RestauranteService {

    @PersistenceContext
    private EntityManager entityManager;

    public RestauranteModel verificaExistenciaDoRestaurante(RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {
        final RestauranteModel restaurante = entityManager.find(RestauranteModel.class, realizarPedidoOfflineRequest.getId_Restaurente());
        Optional.ofNullable(restaurante).orElseThrow(() -> new RestauranteNaoEncontrado("Restaurante não encontrado"));
        return restaurante;
    }
}
