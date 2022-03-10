package com.DevInHouse.Projeto02.controller.dto;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class QuantidadeGraoDTO implements Comparable<QuantidadeGraoDTO>{

    private String nome;
    private Double estoque;

    @Override
    public int compareTo(QuantidadeGraoDTO o) {
        return o.getEstoque().compareTo(this.getEstoque());
    }
}

