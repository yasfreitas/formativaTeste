package com.teste.formativa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teste.formativa.entities.Produto;
import com.teste.formativa.repository.ProdutoRepository;

import jakarta.transaction.Transactional;

@SpringBootTest
@Transactional
class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@BeforeEach
	void setUp() {
		produtoRepository.deleteAll();
	}
	
	@DisplayName("Testando salvar produto")
	@Test
	void testSalvarProduto() {
		Produto produto = new Produto(null, "Livro", "Quarta Asa", 210.99);
		
		Produto resultado = produtoService.salvaProduto(produto);
		
		assertNotNull(resultado);
		assertEquals("Livro", resultado.getNome());
		assertTrue(resultado.getId()>0);
	}
	
	@DisplayName("Testando listar todos os produtos")
	@Test
	void testbuscaTodosProdutos() {
		Produto produto1 = new Produto(null, "Cadeira", "inox", 21.00);
		Produto produto2 = new Produto(null, "Chocolate", "creme de avelã", 12.77);
		
		produtoService.salvaProduto(produto1);
		produtoService.salvaProduto(produto2);
		
		List<Produto> resultado = produtoService.listarTodos();
		
		assertNotNull(resultado);
		assertEquals(2, resultado.size());
	}
	
	@DisplayName("Testando buscar produto por ID")
	@Test
	void testBuscarPorId() {
		Produto produto = new Produto(null, "Sabão", "em pó", 1.99);
		
		Produto salvo = produtoService.salvaProduto(produto);
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isPresent());
		assertEquals("Sabão", resultado.get().getNome());
	}
	
	
	@DisplayName("Testando atualizar produto")
	@Test
	void testAtualizarHospede() {
		Produto produto = new Produto(null, "Chocolate", "creme de avelã", 12.77);
		
		Produto salvo = produtoService.salvaProduto(produto);
		
		salvo.setNome("Paçoca");
		salvo.setDescricao("amendoim");
		salvo.setPreco(12.77);
		
		Produto atualizado = produtoService.atualizarProduto(salvo);
		
		assertNotNull(atualizado);
		assertEquals("Paçoca", atualizado.getNome());
		assertEquals("amendoim", atualizado.getDescricao());
		assertEquals(12.77, atualizado.getPreco());
	}
	
	@DisplayName("Testando Deletar Hospedes")
	@Test
	void testDeletarProduto() {
		Produto produto = new Produto(null, "Caixa de Bombom", "sortidos", 27.77);
		
		Produto salvo = produtoService.salvaProduto(produto);
		produtoService.deletarProduto(salvo.getId());
		
		Optional<Produto> resultado = produtoService.buscarPorId(salvo.getId());
		
		assertTrue(resultado.isEmpty());
	}

}
