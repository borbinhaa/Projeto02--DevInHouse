package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Grao;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class GraoDTO {

    @NotNull
    @NotBlank
    private String nome;
    private Empresa empresa;
    @NotNull
    @Pattern(regexp = "^[0-9]+$", message = "Favor inserir um número inteiro")
    private String diasColheita;


    public Grao toGrao() {
        Grao grao = new Grao();
        grao.setNome(this.nome);
        grao.setDiasColheita(Long.valueOf(this.diasColheita));
        return grao;
    }

}
