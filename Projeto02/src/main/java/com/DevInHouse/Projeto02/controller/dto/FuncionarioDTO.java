package com.DevInHouse.Projeto02.controller.dto;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Funcionario;
import com.DevInHouse.Projeto02.model.Sexo;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class FuncionarioDTO {

    @NotNull
    @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String sobrenome;
    @CPF
    private String cpf;
    @NotNull @NotBlank
    private String endereco;
    @Pattern(regexp = "^\\([0-9]{2}\\) ?[0-9]{9}$", message = "Digite um telefone valido\nEX: (XX) XXXXXXXXX")
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private LocalDate dataContratacao;
    private Empresa empresa;

    public Funcionario toFuncionario() {
        Funcionario funcionario = new Funcionario();
        funcionario.setNome(this.nome);
        funcionario.setSobrenome(this.sobrenome);
        funcionario.setCpf(this.cpf);
        funcionario.setEndereco(this.endereco);
        funcionario.setTelefone(this.telefone);
        funcionario.setSexo(this.sexo);
        funcionario.setDataNascimento(this.dataNascimento);
        funcionario.setDataContratacao(this.dataContratacao);
        funcionario.setEmpresa(empresa);
        return funcionario;
    }
}
