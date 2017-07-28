package com.tarefa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	
	@RequestMapping
	public ModelAndView index(){
		return new ModelAndView("usuario/index");
	}
}
