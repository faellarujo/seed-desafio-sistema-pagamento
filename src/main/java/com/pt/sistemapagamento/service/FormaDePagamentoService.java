package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaDePagamentoService {

    public List<FormaDePagamentoModel> getListaDePagamentoDisponivel(Long id_usuario, Long id_restaurante, EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT f FROM FormaDePagamentoModel f WHERE f.usuarioModel.id = :id_usuario AND f.restauranteModel.id = :id_restaurante");
        query.setParameter("id_usuario", id_usuario);
        query.setParameter("id_restaurante", id_restaurante);
        return query.getResultList();
    }

    public List<FormaDePagamentoModel> getListaDePagamentoDisponivelParaFraudadores(Long id_usuario, Long id_restaurante, EntityManager entityManager) {
        Query query = entityManager.createQuery("SELECT f FROM FormaDePagamentoModel f WHERE f.usuarioModel.id = :id_usuario AND f.restauranteModel.id = :id_restaurante AND f.pagamentoOnline = false");
        query.setParameter("id_usuario", id_usuario);
        query.setParameter("id_restaurante", id_restaurante);
        return query.getResultList();
    }
}