package com.DevInHouse.Projeto02.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


//@NamedNativeQuery(name = "GraoRepository.findGraoEstoque",
//        query = "select graos.nome as nome, fazendas.estoque as estoque from graos inner join fazendas ON fazendas.grao = graos.id where fazendas.empresa = :id",
//        resultSetMapping = "Mapping.QuantidadeGrao2DTO")

@Getter
@Setter
@Entity
@Table(name = "graos")
public class Grao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @ManyToOne
    private Empresa empresa;
    @Column(name = "dias_colheita")
    @NotNull
    private Long diasColheita;


}
