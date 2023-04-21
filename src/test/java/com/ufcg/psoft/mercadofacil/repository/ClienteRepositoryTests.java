package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Produto;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@DisplayName("Testes do repositório de Clientes")
public class ClienteRepositoryTests {

    @Autowired
    ClienteRepository driver;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    Cliente cliente;

    Carrinho carrinho;

    Cliente cliente2;
    Carrinho carrinho2;

    @BeforeEach
    void setup() {
        cliente = Cliente.builder()
                .cpf(12345678L)
                .idade(10)
                .endereco("UFCG")
                .carrinho(carrinho)
                .nome("André")
                .build();

        carrinho = Carrinho.builder()
                .cliente(cliente)
                .build();

        carrinho = carrinhoRepository.save(carrinho);
        cliente = driver.save(cliente);
    }

    @AfterEach
    void tearDown() {

        driver.deleteAll();
        carrinhoRepository.deleteAll();

    }

    @Test
    void testTrue() {
        assertTrue(true);
    }

    @Test
    @DisplayName("Quando procuro um cliente com dados válidos")
    void testQuandoEncontraCliente() {
        //Arrange
        //Act
//        Cliente preResultado = driver.save(cliente);
        assertEquals(driver.findAll().size(), 1);

        Cliente resultado = driver.findById(cliente.getId()).get();


        assertNotNull(resultado);
        assertEquals(12345678L, resultado.getCpf());
        assertEquals(10, resultado.getIdade());
        assertEquals("UFCG", resultado.getEndereco());
        assertEquals("André", resultado.getNome());
    }

    @Test
    @DisplayName("Quando criar um novo produto com dados válidos")
    void testQuandoCriarProduto() {
        //Arrange
        //Act
        Cliente resultado = driver.save(cliente);
        //Assert
        //Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        // Não tenho mais controle sobre o id
        assertEquals(12345678L, resultado.getCpf());
        assertEquals(10, resultado.getIdade());
        assertEquals("UFCG", resultado.getEndereco());
        assertEquals("André", resultado.getNome());
    }

    @Test
    @DisplayName("Quando atualizar um cliente com dados válidos")
    void testQuandoAtualizarCliente() {
        //Arrange
        Long id = driver.save(cliente).getId();
        Cliente produtoAtualizado = driver.findById(id).get();
        produtoAtualizado.setNome("AndréAlterado");

        //Act
        Cliente resultado = driver.save(produtoAtualizado);

        //Assert
        //Assert
        assertNotNull(resultado);
        assertNotNull(resultado.getId());
        assertEquals(id, resultado.getId());
        assertEquals(12345678L, resultado.getCpf());
        assertEquals(10, resultado.getIdade());
        assertEquals("UFCG", resultado.getEndereco());
        assertEquals("AndréAlterado", resultado.getNome());
    }

    @Test
    @DisplayName("Quando deletar um cliente existente")
    void testQuandoDeletarCliente() {
        //Arrange

        //Act
        driver.deleteById(cliente.getId());

        //Assert
        assertEquals(driver.findAll().size(), 0);
    }

    @Test
    @DisplayName("Quando adiciona um novo cliente")
    void testQuandoAdicionarClienteInexistente() {
        //Arrange


        cliente2 = Cliente.builder()
                .cpf(87654321L)
                .idade(20)
                .endereco("UFCG - Sousa")
                .carrinho(carrinho2)
                .nome("Juliana")
                .build();

        carrinho2 = Carrinho.builder()
                .cliente(cliente2)
                .build();

        carrinho2 = carrinhoRepository.save(carrinho2);
        cliente2 = driver.save(cliente2);


        //Act
        Cliente resultado = driver.findById(cliente2.getId()).get();

        //Assert
        assertNotNull(resultado);
        assertEquals(87654321L, resultado.getCpf());
        assertEquals(20, resultado.getIdade());
        assertEquals("UFCG - Sousa", resultado.getEndereco());
        assertNotNull(resultado.getCarrinho());

        assertEquals("Juliana", resultado.getNome());

        assertEquals(driver.findAll().size(), 2);
    }

    @Test
    @DisplayName("Quando tentar deletar um produto inexistente")
    void testQuandoDeletarProdutoInexistente() {
        //Arrange
        Long idClienteInexistente = 9999L;

        //Act
        driver.deleteById(idClienteInexistente);
        Optional<Cliente> resultado = driver.findById(idClienteInexistente);

        //Assert
        assertFalse(resultado.isPresent());
    }
}
