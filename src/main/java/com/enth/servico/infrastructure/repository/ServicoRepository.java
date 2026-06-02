package com.enth.servico.infrastructure.repository;

import com.enth.servico.infrastructure.entity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Long> {
}
