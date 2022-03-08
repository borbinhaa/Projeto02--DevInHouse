package com.DevInHouse.Projeto02.controller;

import com.DevInHouse.Projeto02.controller.dto.FazendaColheitaDTO;
import com.DevInHouse.Projeto02.controller.dto.FazendaDTO;
import com.DevInHouse.Projeto02.controller.dto.GraoDTO;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.model.Grao;
import com.DevInHouse.Projeto02.service.FazendaService;
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
@RequestMapping("/fazendas")
public class FazendaController {

    private FazendaService fazendaService;
    private GraoService graoService;

    @GetMapping("/{empresaId}")
    public ResponseEntity<List<Fazenda>> index(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(fazendaService.findByEmpresaId(empresaId));
    }

    @GetMapping("/{empresaId}/qtd")
    public ResponseEntity<Integer> len(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(fazendaService.qtdFazendas(empresaId));
    }

    @GetMapping("/{empresaId}/colheita")
    public ResponseEntity<List<FazendaColheitaDTO>> mostraColheita(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(fazendaService.proximaColheita(empresaId));
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<Fazenda> create(@Valid @RequestBody FazendaDTO fazendaDTO, @PathVariable Long empresaId, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.build(fazendaDTO);
        return ResponseEntity.created(uri).body(fazendaService.save(empresaId, fazendaDTO.toFazenda()));
    }

}
