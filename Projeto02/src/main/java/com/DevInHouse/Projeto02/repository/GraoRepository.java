package com.DevInHouse.Projeto02.repository;

import com.DevInHouse.Projeto02.model.Grao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GraoRepository extends JpaRepository<Grao, Long> {
}
