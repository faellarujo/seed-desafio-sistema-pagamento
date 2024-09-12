package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.exception.UsuarioNaoEncontrado;
import com.pt.sistemapagamento.model.UsuarioModel;
import com.pt.sistemapagamento.request.RealizarPedidoOfflineRequest;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @PersistenceContext
    private EntityManager entityManager;

    public UsuarioModel verificaExistenciaDoUsuario(RealizarPedidoOfflineRequest realizarPedidoOfflineRequest) {
        final UsuarioModel usuario = entityManager.find(UsuarioModel.class, realizarPedidoOfflineRequest.getId_Usuario());
        Optional.ofNullable(usuario).orElseThrow(() -> new UsuarioNaoEncontrado("Usuário não encontrado"));
        return usuario;
    }
}
