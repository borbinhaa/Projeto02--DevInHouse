package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

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
    private Double estoque;
    private Empresa empresa;
    @NotNull
    private LocalDate ultimaColheita;


    public Fazenda toFazenda() {
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(this.nome);
        fazenda.setEndereco(this.endereco);
        fazenda.setGrao(this.grao);
        fazenda.setEstoque(this.estoque);
        fazenda.setUltimaColheita(this.ultimaColheita);
        return fazenda;
    }
}
