package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.controller.dto.FazendaProximaColheitaDTO;
import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.repository.FazendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Service
public class FazendaService {

    private FazendaRepository fazendaRepository;
    private EmpresaService empresaService;

    public Fazenda findById(Long id) {
        return fazendaRepository.findById(id).orElseThrow();
    }

    public List<Fazenda> findByEmpresaId(Long empresaId){
        Empresa empresa = empresaService.findById(empresaId);
        return fazendaRepository.findByEmpresa(empresa);
    }

    public int qtdFazendas(Long empresaId) {
        return findByEmpresaId(empresaId).size();
    }

    public List<FazendaProximaColheitaDTO> proximaColheita(Long empresaId) {
        return findByEmpresaId(empresaId).stream().map(FazendaProximaColheitaDTO::new).toList();
    }

    public Fazenda save(Long id, Fazenda fazenda) {
        Empresa empresa = empresaService.findById(id);
        fazenda.setEmpresa(empresa);
        return fazendaRepository.save(fazenda);
    }

    public Fazenda colheita(Double qtd, Fazenda fazenda) {
        fazenda.setEstoque(fazenda.getEstoque() + qtd);
        fazenda.setUltimaColheita(LocalDate.now());
        fazendaRepository.save(fazenda);
        return fazenda;
    }

    public Fazenda saque(Double qtd, Fazenda fazenda) {
        double estoque = fazenda.getEstoque() - qtd;
        if (estoque < 0){
            throw new IllegalArgumentException("Quantidade maior que o estoque");
        }
        fazenda.setEstoque(estoque);
        fazendaRepository.save(fazenda);
        return fazenda;
    }


}
