package com.pt.sistemapagamento.service;

import com.pt.sistemapagamento.model.UsuarioModel;
import com.pt.sistemapagamento.model.PossiveisFraudadores;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AntiFraudeService implements com.pt.sistemapagamento.antiFraude.AntiFraude {


    @Override
    public boolean antiFraude(UsuarioModel usuarioModel, List<PossiveisFraudadores> antiFraude) {
        for (PossiveisFraudadores possiveisFraudadores : antiFraude) {
            try {
                if (possiveisFraudadores.getEmail().equals(usuarioModel.getEmail())) {
                    System.out.println("Usuario é fraudador");
                    return true; // Retorna true se o usuário for identificado como fraudador
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            }
        }
        return false; // Retorna false se o usuário não for identificado como fraudador
    }
}