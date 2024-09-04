package com.pt.sistemapagamento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Entity
public class PossiveisFraudadores {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    private Long id;

    private String email;

    public PossiveisFraudadores() {
    }

    public PossiveisFraudadores(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PossiveisFraudadores{" +
                "email='" + email + '\'' +
                '}';
    }


}
