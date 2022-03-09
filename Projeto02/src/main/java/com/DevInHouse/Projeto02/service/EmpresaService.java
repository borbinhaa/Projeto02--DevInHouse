package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.repository.EmpresaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EmpresaService {

    private EmpresaRepository empresaRepository;

    public List<Empresa> findAll() {
        return empresaRepository.findAll();
    }

    public Empresa findById(Long id) {
        return empresaRepository.findById(id).orElseThrow();
    }

    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}
