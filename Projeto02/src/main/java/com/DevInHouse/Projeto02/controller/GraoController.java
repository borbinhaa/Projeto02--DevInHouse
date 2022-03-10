package com.DevInHouse.Projeto02.controller;

import com.DevInHouse.Projeto02.controller.dto.GraoDTO;
import com.DevInHouse.Projeto02.controller.dto.QuantidadeGraoDTO;
import com.DevInHouse.Projeto02.model.Grao;
import com.DevInHouse.Projeto02.service.GraoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/graos")
public class GraoController {

    private GraoService graoService;

    @GetMapping("/{empresaId}")
    public ResponseEntity<List<Grao>> index(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(graoService.findByEmpresaId(empresaId));
    }

    @GetMapping("/{empresaId}/estoque")
    public ResponseEntity<List<QuantidadeGraoDTO>> estoque(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(graoService.findGraoEstoque(empresaId));
    }


    @PostMapping("/{empresaId}")
    public ResponseEntity<Grao> create(@Valid @RequestBody GraoDTO graoDTO, @PathVariable Long empresaId , UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/graos/" + empresaId).build(graoDTO);
        return ResponseEntity.created(uri).body(graoService.save(empresaId, graoDTO.toGrao()));
    }

}
