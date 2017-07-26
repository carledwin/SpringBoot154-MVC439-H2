package com.tarefa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByUsername(String username);
	
	
}
