package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@Getter
@Setter
public class FazendaDTO {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String endereco;
    @NotNull
    private Grao grao;
    @NotNull
    @Column(name = "estoque_inicial")
    private Double estoqueInicial;
    private Empresa empresa;
    @Column(name = "ultima_colheita")
    private LocalDate ultimaColheita;


    public Fazenda toFazenda() {
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(this.nome);
        fazenda.setEndereco(this.endereco);
        fazenda.setGrao(this.grao);
        fazenda.setEstoqueInicial(this.estoqueInicial);
        fazenda.setUltimaColheita(this.ultimaColheita);
        return fazenda;
    }
}