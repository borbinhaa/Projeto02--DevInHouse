package com.DevInHouse.Projeto02.repository;

import com.DevInHouse.Projeto02.model.Empresa;
import com.DevInHouse.Projeto02.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

    public List<Funcionario> findByEmpresa(Empresa empresa);
}
