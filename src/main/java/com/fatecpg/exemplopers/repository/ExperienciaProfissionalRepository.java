package com.fatecpg.exemplopers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecpg.exemplopers.model.ExperienciaProfissional;

@Repository
public interface ExperienciaProfissionalRepository extends JpaRepository<ExperienciaProfissional, Long> {
    Optional<ExperienciaProfissional> findByIdAndFuncionarioId(Long id, Long funcionarioId);
}
