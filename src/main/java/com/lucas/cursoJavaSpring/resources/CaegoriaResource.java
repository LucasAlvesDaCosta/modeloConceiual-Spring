package com.lucas.cursoJavaSpring.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class CaegoriaResource {
    @RequestMapping(method = RequestMethod.GET)
	public String listar() {
		return "O REST está funcionando!";
	}
}
