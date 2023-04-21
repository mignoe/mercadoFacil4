package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CarrinhoDeComprasRepositoryTests {
    @Autowired
    CarrinhoRepository driver;

    @Autowired
    ClienteRepository clienteRepository;

    Carrinho carrinho;

    Cliente cliente;

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
                .id(1L)
                .lote(new HashSet<>())
                .cliente(cliente)
                .build();


        carrinho = driver.save(carrinho);

    }

    @AfterEach
    void tearDown() {
        driver.deleteAll();
        clienteRepository.deleteAll();
    }

    @Test
    void testTrue() {
        assertTrue(true);
    }
    @Test
    void testGet() {
        Carrinho resultado = driver.findById(1L).get();

        assertEquals(carrinho.getCliente().getNome(), resultado.getCliente().getNome());
        assertEquals(carrinho.getCliente().getCpf(), resultado.getCliente().getCpf());
    }

    @Test
    void testUpdate() {
        Carrinho resultado = driver.findById(carrinho.getId()).get();
        resultado.getCliente().setNome("Pedrinho");
        driver.save(resultado);

        Carrinho resultadoFinal = driver.findById(resultado.getId()).get();

        assertEquals("Pedrinho", resultadoFinal.getCliente().getNome());
    }

    @Test
    void testRemove() {
        // Arrange
        Carrinho resultado = driver.findById(carrinho.getId()).get();

        // Act
        driver.deleteById(resultado.getId());

        // Assert
        assertEquals(driver.findAll().size(), 0);
    }
}
