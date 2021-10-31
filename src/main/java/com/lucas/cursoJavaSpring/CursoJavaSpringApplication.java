package com.lucas.cursoJavaSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.cursoJavaSpring.domain.Categoria;
import com.lucas.cursoJavaSpring.repositories.CategoriaRepository;

@SpringBootApplication
public class CursoJavaSpringApplication implements CommandLineRunner{
	
    @Autowired
	private CategoriaRepository categoriaRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(CursoJavaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
	}

}
