package com.DevInHouse.Projeto02.controller.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ColheitaSaqueDTO {

    @NotNull
    private Double qtd;
}
