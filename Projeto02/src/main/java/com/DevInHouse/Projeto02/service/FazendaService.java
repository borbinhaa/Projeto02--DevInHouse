package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.controller.dto.FazendaColheitaDTO;
import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Fazenda;
import com.DevInHouse.Projeto02.repository.FazendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FazendaService {

    private FazendaRepository fazendaRepository;
    private EmpresaService empresaService;

    public List<Fazenda> findByEmpresaId(Long empresaId){
        Empresa empresa = empresaService.findById(empresaId);
        return fazendaRepository.findByEmpresa(empresa);
    }

    public int qtdFazendas(Long empresaId) {
        return findByEmpresaId(empresaId).size();
    }

    public List<FazendaColheitaDTO> proximaColheita(Long empresaId) {
        return findByEmpresaId(empresaId).stream().map(FazendaColheitaDTO::new).toList();
    }

    public Fazenda save(Long id, Fazenda fazenda) {
        Empresa empresa = empresaService.findById(id);
        fazenda.setEmpresa(empresa);
//        empresa.getFazendas().add(fazenda);
        return fazendaRepository.save(fazenda);
    }


}
