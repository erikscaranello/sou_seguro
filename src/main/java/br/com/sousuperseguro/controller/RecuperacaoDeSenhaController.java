package br.com.sousuperseguro.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.com.sousuperseguro.service.UsersService;

@Controller
public class RecuperacaoDeSenhaController {
	
	@Autowired
	UsersService usersService;
	
	@RequestMapping("/recuperacao_de_senha")
	public ModelAndView index() {
		
		
		ModelAndView modelAndView = new ModelAndView("recuperacaoDeSenha/index");
		return modelAndView;
	}
	
	@RequestMapping("/recuperacao_de_senha/recuperar")
	public @ResponseBody boolean recuperar(HttpServletRequest request) {
		
		return usersService.verificarEmail(request.getParameter("email"));
	
	}
}
