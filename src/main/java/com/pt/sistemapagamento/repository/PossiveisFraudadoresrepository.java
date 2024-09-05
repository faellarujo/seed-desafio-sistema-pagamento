package com.pt.sistemapagamento.repository;

import com.pt.sistemapagamento.model.PossiveisFraudadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PossiveisFraudadoresrepository extends JpaRepository<PossiveisFraudadores, Long> {

    // precisa de um método que retorne toda a lista de fraudadores

    List<PossiveisFraudadores> findAll();
}
