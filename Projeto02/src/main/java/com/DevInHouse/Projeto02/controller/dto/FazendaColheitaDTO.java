package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class FazendaColheitaDTO {

    private Long id;
    private String nome;
    private LocalDate proximaColheita;

    public FazendaColheitaDTO(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.proximaColheita = getProximaColheita(fazenda);
    }

    private LocalDate getProximaColheita(Fazenda fazenda) {
        System.out.println(fazenda);
        Grao grao = fazenda.getGrao();
        return fazenda.getUltimaColheita().plusDays(grao.getDiasColheita());
    }
}
