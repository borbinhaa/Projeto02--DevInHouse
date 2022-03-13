package com.DevInHouse.Projeto02.controller.dto;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class ColheitaSaqueDTO {

    @NotNull
    @Pattern(regexp = "^[0-9]+(\\.[0-9]*)?$", message = "Digite um número maior que zero.")
    private String qtd;
}
