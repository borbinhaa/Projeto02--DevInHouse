package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Grao;
import com.DevInHouse.Projeto02.repository.GraoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class GraoService {

    private GraoRepository graoRepository;
    private EmpresaService empresaService;

    public Grao save(Long id, Grao grao) {
        Empresa empresa = empresaService.findById(id);
        grao.setEmpresa(empresa);
        return graoRepository.save(grao);
    }
}
