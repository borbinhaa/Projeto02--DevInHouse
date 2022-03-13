package com.DevInHouse.Projeto02.controller;

import com.DevInHouse.Projeto02.controller.dto.ColheitaSaqueDTO;
import com.DevInHouse.Projeto02.controller.dto.FazendaDTO;
import com.DevInHouse.Projeto02.controller.dto.FazendaProximaColheitaDTO;
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

    @GetMapping("/{empresaId}/proximacolheita")
    public ResponseEntity<List<FazendaProximaColheitaDTO>> mostraProximaColheita(@PathVariable Long empresaId) {
        return ResponseEntity.ok().body(fazendaService.proximaColheita(empresaId));
    }

    @PostMapping("/{empresaId}")
    public ResponseEntity<Fazenda> create(@Valid @RequestBody FazendaDTO fazendaDTO, @PathVariable Long empresaId, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = uriComponentsBuilder.path("/fazendas/" + empresaId).build(fazendaDTO);
        List<Grao> graosNaEmpresa = graoService.findByEmpresaId(empresaId);
        Grao grao = graoService.findById(Long.valueOf(fazendaDTO.getGraoId()));

        if (!graosNaEmpresa.contains(grao)) {
            throw new IllegalArgumentException("Grão não disponível para a sua fazenda");
        }

        Fazenda fazenda = fazendaDTO.toFazenda();
        fazenda.setGrao(grao);
        return ResponseEntity.created(uri).body(fazendaService.save(empresaId, fazenda));
    }

    @PutMapping("/colheita/{fazendaId}")
    public ResponseEntity<Fazenda> addColheita(@PathVariable Long fazendaId, @Valid @RequestBody ColheitaSaqueDTO colheitaSaqueDTO, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = buildURI(colheitaSaqueDTO, uriComponentsBuilder);
        Fazenda fazenda = getFazenda(fazendaId);
        Double qtd = getQtdDouble(colheitaSaqueDTO);
        return ResponseEntity.created(uri).body(fazendaService.colheita(qtd, fazenda));
    }

    @PutMapping("/saque/{fazendaId}")
    public ResponseEntity<Fazenda> addSaque(@PathVariable Long fazendaId, @Valid @RequestBody ColheitaSaqueDTO colheitaSaqueDTO, UriComponentsBuilder uriComponentsBuilder) {
        URI uri = buildURI(colheitaSaqueDTO, uriComponentsBuilder);
        Fazenda fazenda = getFazenda(fazendaId);
        Double qtd = getQtdDouble(colheitaSaqueDTO);
        return ResponseEntity.created(uri).body(fazendaService.saque(qtd, fazenda));
    }


    private Double getQtdDouble(ColheitaSaqueDTO colheitaSaqueDTO) {
        return Double.valueOf(colheitaSaqueDTO.getQtd());
    }

    private Fazenda getFazenda(Long fazendaId) {
        return fazendaService.findById(fazendaId);
    }

    private URI buildURI(ColheitaSaqueDTO colheitaSaqueDTO, UriComponentsBuilder uriComponentsBuilder) {
        return uriComponentsBuilder.path("/fazendas/").build(colheitaSaqueDTO);
    }

}
