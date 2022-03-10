package com.DevInHouse.Projeto02.controller;

import com.DevInHouse.Projeto02.controller.dto.FuncionarioDTO;
import com.DevInHouse.Projeto02.model.Funcionario;
import com.DevInHouse.Projeto02.service.FuncionarioService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private FuncionarioService funcionarioService;

    @GetMapping("/{empresaId}")
    public ResponseEntity<List<Funcionario>> getByEmpresa(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(funcionarioService.findByEmpresaId(empresaId));
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<Funcionario> create(@Valid @RequestBody FuncionarioDTO funcionarioDTO, @PathVariable Long empresaId , UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/funcionarios/" + empresaId).build(funcionarioDTO);
        return ResponseEntity.created(uri).body(funcionarioService.save(empresaId, funcionarioDTO.toFuncionario()));
    }

}
