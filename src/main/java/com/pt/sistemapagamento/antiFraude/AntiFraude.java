package com.pt.sistemapagamento.antiFraude;

import com.pt.sistemapagamento.model.PossiveisFraudadores;
import com.pt.sistemapagamento.model.UsuarioModel;

import java.util.List;

public interface AntiFraude {
    boolean antiFraude(UsuarioModel usuarioModel, List<PossiveisFraudadores> antiFraude);
}
