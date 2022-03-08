package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Grao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class GraoDTO {

    @NotNull
    @NotBlank
    private String nome;
    private Empresa empresa;
    @NotNull
    private Long diasColheita;

    public Grao toGrao() {
        Grao grao = new Grao();
        grao.setNome(this.nome);
        grao.setDiasColheita(this.diasColheita);
        return grao;
    }

}
