package com.teste.formativa.entities;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class ProdutoTest {
	
private Produto produto;
	
	@BeforeEach
	void setUp() {
		//Arrange
		produto = new Produto(1L, "Pão", "de forma sem casca", 17.99);
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo ID")
	void testId() {
		//Act
		produto.setId(2L);
		//Arrange
		assertEquals(2l, produto.getId());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Nome")
	void testNome() {
		//Act
		produto.setNome("Suco de Maçã");
		//Arrange
		assertEquals("Suco de Maçã", produto.getNome());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo Descrição")
	void testDescricao() {
		//Act
		produto.setDescricao("Suco integral natural");
		//Arrange
		assertEquals("Suco integral natural", produto.getDescricao());
	}
	
	@Test
	@DisplayName("Testando o Getter e Setter do campo preco")
	void testpreco() {
		//Act
		produto.setPreco(21.23);
		//Arrange
		assertEquals(21.23 , produto.getPreco());
	}
	
	@Test
	@DisplayName("Testando o construtor com todos os argumentos")
	void testConstrutorAll() {
		//Act
		Produto novoProduto = new Produto(3L, "Chocolate", "Bolacha, Caramelo e Chocolate", 4.99);
		//Assertion
		assertAll("novoHospede", 
				()-> assertEquals(3L, novoProduto.getId()), 
				()-> assertEquals("Chocolate", novoProduto.getNome()),
				()-> assertEquals("Bolacha, Caramelo e Chocolate", novoProduto.getDescricao()),
				()-> assertEquals(4.99, novoProduto.getPreco()));
	}

	

}
