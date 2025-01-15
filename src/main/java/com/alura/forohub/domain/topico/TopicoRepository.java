package com.alura.forohub.domain.topico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;

import java.util.Optional;

import org.springframework.data.domain.Pageable;
public interface TopicoRepository extends JpaRepository<Topico, Long> {
    boolean existsByTituloAndMensaje(String titulo, String mensaje);

    Page<Topico> findByActivoTrue(Pageable paginacion);

    Optional<Topico> findByIdAndActivoTrue(Long id);
}
