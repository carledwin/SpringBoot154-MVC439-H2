package com.tarefa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/tarefa")
public class TarefaController {

	
	@RequestMapping
	public ModelAndView index(){
		return new ModelAndView("tarefa/index");
	}
}
