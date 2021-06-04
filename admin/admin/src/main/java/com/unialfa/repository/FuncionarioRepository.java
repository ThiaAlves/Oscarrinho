package com.unialfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unialfa.model.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long>{

}
