package com.DevInHouse.Projeto02.service;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Funcionario;
import com.DevInHouse.Projeto02.repository.FuncionarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class FuncionarioService {

    private FuncionarioRepository funcionarioRepository;
    private EmpresaService empresaService;

    public Funcionario save(Long empresaId, Funcionario funcionario) {
        Empresa empresa = empresaService.findById(empresaId);
        funcionario.setEmpresa(empresa);
        return funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> findByEmpresaId(Long id) {
        Empresa empresa = empresaService.findById(id);
        return funcionarioRepository.findByEmpresa(empresa);
    }

    public int qtdFuncionario(Long empresaId) {
        return findByEmpresaId(empresaId).size();
    }
}
