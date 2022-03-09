package com.DevInHouse.Projeto02.controller;


import com.DevInHouse.Projeto02.controller.dto.EmpresaDTO;
import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.service.EmpresaService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
public class EmpresaController {

    private EmpresaService empresaService;

    @GetMapping
    public ResponseEntity<List<Empresa>> index() {
        return ResponseEntity.ok().body(empresaService.findAll());
    }

    @PostMapping
    public ResponseEntity<Empresa> create(@Valid @RequestBody EmpresaDTO empresaDTO,  UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.build(empresaDTO);
        return ResponseEntity.created(uri).body(empresaService.save(empresaDTO.toEmpresa()));
    }
}
