package com.DevInHouse.Projeto02.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull
    @NotBlank
    private String sobrenome;
    @CPF
    private String cpf;
    @NotNull
    @NotBlank
    private String endereco;
    @Pattern(regexp = "^\\([0-9]{2}\\) ?[0-9]{9}$", message = "Digite um telefone valido\nEX: (XX) XXXXXXXXX")
    private String telefone;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @NotNull
    private LocalDate dataNascimento;
    @NotNull
    private LocalDate dataContratacao;
    @ManyToOne
//    @JsonIgnore
    private Empresa empresa;


}
