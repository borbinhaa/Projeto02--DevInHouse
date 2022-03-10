package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FazendaProximaColheitaDTO {

    private Long id;
    private String nome;
    private LocalDate proximaColheita;

    public FazendaProximaColheitaDTO(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.proximaColheita = getProximaColheita(fazenda);
    }

    private LocalDate getProximaColheita(Fazenda fazenda) {
        Grao grao = fazenda.getGrao();
        return fazenda.getUltimaColheita().plusDays(grao.getDiasColheita());
    }
}
