package com.pt.sistemapagamento.fraude;

import com.pt.sistemapagamento.model.PossiveisFraudadores;
import com.pt.sistemapagamento.model.UsuarioModel;

import java.util.List;

public interface AntiFraude {

    public boolean antiFraude(UsuarioModel usuarioModel , List<PossiveisFraudadores> possiveisFraudadores);
}
