package com.teste.formativa.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.teste.formativa.entities.Produto;
import com.teste.formativa.repository.ProdutoRepository;


@DataJpaTest
class ProdutoRepositoryTest {

	@Autowired
	private ProdutoRepository produtoRepository;
	
	@DisplayName("Testando o Save")
	@Test
	void testSalvarRepository() {
		
		Produto produto1 = new Produto(null, "Chocolate", "creme de avelã", 12.21);
		Produto saveProduto = produtoRepository.save(produto1);
		
		assertNotNull(saveProduto);
		assertTrue(saveProduto.getId()>0);
	}
	
	@DisplayName("Testando Get para todos os Hóspedes")
	@Test
	void testGetAllRepository() {
		
		Produto produto1 = new Produto(null, "Livro", "Caçadora de Dragões", 45.32);
		Produto produto2 = new Produto(null, "Máscara Capilar", "Morte Súbita", 52.99);
		
		produtoRepository.save(produto1);
		produtoRepository.save(produto2);
		
		List<Produto> produtoList = produtoRepository.findAll();
		
		assertNotNull(produtoList);
		assertEquals(2, produtoList.size());
		
	}
	
	@DisplayName("Testando Get By ID")
	@Test
	void testGetById() {
		
		Produto produto1 = new Produto(null, "Máscara Facial", "Pepino e karité", 3.99);
		
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		
		assertNotNull(saveProduto);
		assertEquals(produto1.getId(), saveProduto.getId());
		
	}
	
	@DisplayName("Testando o UpDate")
	@Test
	void testUpdateProduto() {
		
		Produto produto1 = new Produto(null, "Fita isolante", "3M", 2.78);
		
		produtoRepository.save(produto1);
		
		Produto saveProduto = produtoRepository.findById(produto1.getId()).get();
		produto1.setNome("Fita Crepe");
		produto1.setDescricao("3mm");
		produto1.setPreco(1.43);
		
		Produto updateProduto = produtoRepository.save(saveProduto);
		
		assertNotNull(updateProduto);
		assertEquals("Fita Crepe", updateProduto.getNome());
		assertEquals("3mm", updateProduto.getDescricao());
		assertEquals(1.43, updateProduto.getPreco());
		
	}
	
	@DisplayName("Testando Delete")
	@Test
	void testDeleteProduto() {
		Produto produto1 = new Produto(null, "Lamparina", "à fogo", 123.00);
		produtoRepository.save(produto1);
		produtoRepository.deleteById(produto1.getId());
		Optional<Produto> produtoOptional = produtoRepository.findById(produto1.getId());		
		assertTrue(produtoOptional.isEmpty());
	
	}

}
