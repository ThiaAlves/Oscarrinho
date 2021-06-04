package com.unialfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unialfa.model.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
