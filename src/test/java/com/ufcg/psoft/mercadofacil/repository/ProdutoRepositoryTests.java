package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@DisplayName("Testes do repositório de Produtos")
public class ProdutoRepositoryTests {

    @Autowired
    ProdutoRepository driver;
    @Autowired
    ClienteRepository clienteRepository;
    @Autowired
    LoteRepository loteRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;

    Produto produto;

    @BeforeEach
    void setup() {
        produto = driver.save(Produto.builder()
                .nome("Produto Dez")
                .fabricante("Fabricante Dez")
                .codigoDeBarras("1234567890123")
                .preco(100.00)
                .build());
    }

    @AfterEach
    void tearDown() {

        driver.deleteAll();
        carrinhoRepository.deleteAll();
        loteRepository.deleteAll();
        clienteRepository.deleteAll();
    }

    @Test
    void testTrue() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Quando procuro um produto com dados válidos")
    void testQuandoEncontraProduto() {
        //Arrange
        //Act
        driver.save(produto);
        Produto resultado = driver.findById(produto.getId()).get();

        //Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals("Produto Dez", resultado.getNome());
        assertEquals("Fabricante Dez", resultado.getFabricante());
        assertEquals("1234567890123", resultado.getCodigoDeBarras());
        assertEquals(100.00, resultado.getPreco());
    }

    @Test
    @DisplayName("Quando criar um novo produto com dados válidos")
    void testQuandoCriarProduto() {
        //Arrange
        //Act
        Produto resultado = driver.save(produto);
        //Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals("Produto Dez", resultado.getNome());
        assertEquals("Fabricante Dez", resultado.getFabricante());
        assertEquals("1234567890123", resultado.getCodigoDeBarras());
        assertEquals(100.00, resultado.getPreco());
    }

    @Test
    @DisplayName("Quando atualizar um produto com dados válidos")
    void testQuandoAtualizarProduto() {
        //Arrange
        driver.save(produto);
        Produto produtoAtualizado = driver.findById(produto.getId()).get();
        produtoAtualizado.setPreco(150.00);

        //Act
        Produto resultado = driver.save(produtoAtualizado);

        //Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals("Produto Dez", resultado.getNome());
        assertEquals("Fabricante Dez", resultado.getFabricante());
        assertEquals("1234567890123", resultado.getCodigoDeBarras());
        assertEquals(150.00, resultado.getPreco());
    }

    @Test
    @DisplayName("Quando deletar um produto existente")
    void testQuandoDeletarProduto() {
        //Arrange
        driver.save(produto);

        //Act
        driver.deleteById(produto.getId());
        Optional<Produto> resultado = driver.findById(produto.getId());

        //Assert
        assertFalse(resultado.isPresent());
    }

    @Test
    @DisplayName("Quando atualizar um produto inexistente")
    void testQuandoAtualizarProdutoInexistente() {
        //Arrange
        Produto produtoInexistente = Produto.builder()
                .nome("Produto Inexistente")
                .fabricante("Fabricante Inexistente")
                .codigoDeBarras("9999999999999")
                .preco(200.00)
                .build();

        //Act
        Produto resultado = driver.save(produtoInexistente);

        //Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals("Produto Inexistente", resultado.getNome());
        assertEquals("Fabricante Inexistente", resultado.getFabricante());
        assertEquals("9999999999999", resultado.getCodigoDeBarras());
        assertEquals(200.00, resultado.getPreco());
    }

    @Test
    @DisplayName("Quando tentar deletar um produto inexistente")
    void testQuandoDeletarProdutoInexistente() {
        //Arrange
        Long idProdutoInexistente = 9999L;

        //Act
        driver.deleteById(idProdutoInexistente);
        Optional<Produto> resultado = driver.findById(idProdutoInexistente);

        //Assert
        assertFalse(resultado.isPresent());
    }
}
