package com.pt.sistemapagamento.repository;

import com.pt.sistemapagamento.model.FormaDePagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FormaDePagamentoRepository extends JpaRepository<FormaDePagamentoModel, Long> {

    public FormaDePagamentoModel findById(long id);
}
