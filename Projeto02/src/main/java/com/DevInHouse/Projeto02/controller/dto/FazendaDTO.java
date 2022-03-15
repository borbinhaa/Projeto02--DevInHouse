package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[0-9]+$", message = "Favor inserir um número inteiro")
    private String graoId;
    @NotNull
    @Pattern(regexp = "^[0-9]+(\\.[0-9]*)?$", message = "Digite um número maior que zero."  )
    private String estoque;
    private Empresa empresa;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate ultimaColheita;


    public Fazenda toFazenda() {
        Fazenda fazenda = new Fazenda();
        fazenda.setNome(this.nome);
        fazenda.setEndereco(this.endereco);
        fazenda.setEstoque(Double.valueOf(this.estoque));
        fazenda.setUltimaColheita(this.ultimaColheita);
        return fazenda;
    }
}
