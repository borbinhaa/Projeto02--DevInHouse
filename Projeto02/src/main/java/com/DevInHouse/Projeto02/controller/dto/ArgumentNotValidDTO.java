package com.DevInHouse.Projeto02.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ArgumentNotValidDTO {
    private String campo;
    private String erro;

}
