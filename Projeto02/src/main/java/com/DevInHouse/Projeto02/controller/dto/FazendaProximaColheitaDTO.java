package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class FazendaProximaColheitaDTO {

    private Long id;
    private String nome;
    private String proximaColheita;

    public FazendaProximaColheitaDTO(Fazenda fazenda) {
        this.id = fazenda.getId();
        this.nome = fazenda.getNome();
        this.proximaColheita = getProximaColheita(fazenda);
    }

    private String getProximaColheita(Fazenda fazenda) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Grao grao = fazenda.getGrao();
        LocalDate diaProximaColheita = fazenda.getUltimaColheita().plusDays(grao.getDiasColheita());
        return diaProximaColheita.format(formatter);
    }
}
