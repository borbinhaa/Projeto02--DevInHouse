package com.DevInHouse.Projeto02.controller.dto;


import com.DevInHouse.Projeto02.model.Fazenda;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class colheitaSaqueDTO {

    @NotNull
    private Fazenda fazenda;
    @NotNull
    private Double qtd;
}
