package com.DevInHouse.Projeto02.model;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.br.CNPJ;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "empresas")
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @CNPJ
    private String cnpj;
    @NotNull
    @NotBlank
    private String endereco;
//    @OneToMany
//    private List<Funcionario> funcionarios;
//    @OneToMany
//    private List<Fazenda> fazendas;
//    @OneToMany
//    private List<Grao> graos;
}
