package com.unialfa.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.unialfa.model.Folha;
import com.unialfa.model.Funcionario;

public interface FolhaRepository extends JpaRepository<Folha, Long> {

	List<Folha> findByFuncionario(Funcionario funcionario);
	
	@Query("select f from Folha f where f.funcionario = ?1 and competencia = ?2 ")
	Folha queryFolhaMes(Funcionario func, LocalDate competencia);
}
