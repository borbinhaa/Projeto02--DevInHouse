package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Funcionario;
import com.DevInHouse.Projeto02.model.Grao;
import com.DevInHouse.Projeto02.repository.FuncionarioRepository;
import com.DevInHouse.Projeto02.repository.GraoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class GraoService {

    private GraoRepository graoRepository;
    private EmpresaService empresaService;

    public Grao save(Long id, Grao grao) {
        Empresa empresa = empresaService.findById(id);
        grao.setEmpresa(empresa);
        empresa.getGraos().add(grao);
        return graoRepository.save(grao);
    }
}
