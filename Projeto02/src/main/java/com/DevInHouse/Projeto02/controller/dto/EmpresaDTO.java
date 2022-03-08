package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class EmpresaDTO {

    @NotNull
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    @NotBlank
    private String endereco;

    public Empresa toEmpresa() {
        Empresa empresa = new Empresa();
        empresa.setNome(this.nome);
        empresa.setCnpj(this.cnpj);
        empresa.setEndereco(this.endereco);
        return empresa;
    }
}
