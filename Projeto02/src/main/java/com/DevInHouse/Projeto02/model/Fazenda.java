package com.DevInHouse.Projeto02.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString
@Getter
@Setter
@Entity
@Table(name = "fazendas")
public class Fazenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotBlank
    private String nome;
    @NotNull @NotBlank
    private String endereco;
    @ManyToOne
    private Grao grao;
    @NotNull
    @Column(name = "estoque_inicial")
    private Double estoqueInicial;
    @ManyToOne
    private Empresa empresa;
    @Column(name = "ultima_colheita")
    private LocalDate ultimaColheita;

}
