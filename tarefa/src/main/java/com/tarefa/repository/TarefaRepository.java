package com.tarefa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarefa.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

	List<Tarefa> findByTarefa(String tarefa);
}
