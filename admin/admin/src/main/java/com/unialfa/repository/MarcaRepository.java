package com.unialfa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unialfa.model.Funcionario;
import com.unialfa.model.Marca;
import com.unialfa.model.Usuario;

public interface MarcaRepository extends JpaRepository<Marca, Long>{

}
