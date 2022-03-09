package com.DevInHouse.Projeto02.controller;

import com.DevInHouse.Projeto02.controller.dto.FazendaProximaColheitaDTO;
import com.DevInHouse.Projeto02.controller.dto.FazendaDTO;
import com.DevInHouse.Projeto02.controller.dto.colheitaSaqueDTO;
import com.DevInHouse.Projeto02.model.Fazenda;
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

    @GetMapping("/{empresaId}/proximacolheita")
    public ResponseEntity<List<FazendaProximaColheitaDTO>> mostraProximaColheita(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(fazendaService.proximaColheita(empresaId));
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<Fazenda> create(@Valid @RequestBody FazendaDTO fazendaDTO, @PathVariable Long empresaId, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/fazendas/" + empresaId).build(fazendaDTO);
        return ResponseEntity.created(uri).body(fazendaService.save(empresaId, fazendaDTO.toFazenda()));
    }

    @PostMapping("/colheita")
    public ResponseEntity<Fazenda> addColheita(@Valid @RequestBody colheitaSaqueDTO colheitaSaqueDTO, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/fazendas/").build(colheitaSaqueDTO);
        Fazenda fazenda = colheitaSaqueDTO.getFazenda();
        Double qtd = colheitaSaqueDTO.getQtd();
        return ResponseEntity.created(uri).body(fazendaService.colheita(qtd, fazenda));
    }

    @PostMapping("/saque")
    public ResponseEntity<Fazenda> addSaque(@Valid @RequestBody colheitaSaqueDTO colheitaSaqueDTO, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/fazendas/").build(colheitaSaqueDTO);
        Fazenda fazenda = colheitaSaqueDTO.getFazenda();
        Double qtd = colheitaSaqueDTO.getQtd();
        return ResponseEntity.created(uri).body(fazendaService.saque(qtd, fazenda));
    }


}
