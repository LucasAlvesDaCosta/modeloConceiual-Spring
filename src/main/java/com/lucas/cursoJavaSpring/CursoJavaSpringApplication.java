package com.lucas.cursoJavaSpring;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lucas.cursoJavaSpring.domain.Categoria;
import com.lucas.cursoJavaSpring.domain.Cidade;
import com.lucas.cursoJavaSpring.domain.Cliente;
import com.lucas.cursoJavaSpring.domain.Endereco;
import com.lucas.cursoJavaSpring.domain.Estado;
import com.lucas.cursoJavaSpring.domain.Produto;
import com.lucas.cursoJavaSpring.domain.enuns.TipoCliente;
import com.lucas.cursoJavaSpring.repositories.CategoriaRepository;
import com.lucas.cursoJavaSpring.repositories.CidadeRepository;
import com.lucas.cursoJavaSpring.repositories.ClienteRepository;
import com.lucas.cursoJavaSpring.repositories.EnderecoRepository;
import com.lucas.cursoJavaSpring.repositories.EstadoRepository;
import com.lucas.cursoJavaSpring.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoJavaSpringApplication implements CommandLineRunner{
	
    @Autowired
	private CategoriaRepository categoriaRepository;
    
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CidadeRepository cidadeRepository;
    
    @Autowired
    private EstadoRepository estadoRepository;
    
    @Autowired
    ClienteRepository clienteRepository;
    
    @Autowired
    EnderecoRepository enderecoRepository;
    
	public static void main(String[] args) {
		SpringApplication.run(CursoJavaSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null,"Uberlândia", est1);
		Cidade c2 = new Cidade(null,"São Paulo", est2);
		Cidade c3 = new Cidade(null,"Campinas", est2);
		
		Cliente cli1 = new Cliente(null, "Maria","maria@gmail.com","36378912377",TipoCliente.PESSOAFISICA);
		cli1.getTelefones().addAll(Arrays.asList("98987643","87997655"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apto 303", "Jardim", "38023804", cli1, c1);
		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "sala 800", "Centro", "38777012", cli1, c2);
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));

		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
        est1.getCidades().addAll(Arrays.asList(c1));
        est2.getCidades().addAll(Arrays.asList(c2,c3));
        
        categoriaRepository.saveAll(Arrays.asList(cat1, cat2));//save atualizado para saveAll Spring 2.0...
		produtoRepository.saveAll(Arrays.asList(p1,p2,p3));
		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		clienteRepository.saveAll(Arrays.asList(cli1));
		enderecoRepository.saveAll(Arrays.asList(e1,e2));
	}

}
