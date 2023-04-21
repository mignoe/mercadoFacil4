package com.ufcg.psoft.mercadofacil.repository;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;
import org.hibernate.Hibernate;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class LoteRepositoryTests {

    @Autowired
    LoteRepository driver;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;
    Lote lote;

    Produto produto;

    Carrinho carrinho;
    @BeforeEach
    void setup() {
        produto = Produto.builder()
                        .nome("Produto Dez")
                        .fabricante("Fabricante Dez")
                        .codigoDeBarras("1234567890123")
                        .preco(100.00)
                        .lotes(new HashSet<>(Collections.singletonList(lote)))
                        .build();

        carrinho = Carrinho.builder().lote(new HashSet<>()).build();
        carrinho.getLote().add(lote);

        lote = driver.save(Lote.builder()
                        .numeroDeItens(30)
                        .carrinho(new HashSet<>())
                .produto(produto)
                .build());


    }

    @AfterEach
    void teardown() {
        driver.deleteAll();
        produtoRepository.deleteAll();
        carrinhoRepository.deleteAll();
    }

    @Test
    void assertTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void testGetById() {
        Lote resultado = driver.findById(lote.getId()).get();

        assertEquals(lote.getNumeroDeItens(), resultado.getNumeroDeItens());
    }

    @Test
    void testUpdate() {
        Lote resultado = driver.findById(lote.getId()).get();

        int previousItemsNumber = resultado.getNumeroDeItens();
        resultado.setNumeroDeItens(previousItemsNumber - 5);

        driver.save(resultado);

        Lote resultadoFinal = driver.findById(resultado.getId()).get();

        assertEquals(resultadoFinal.getNumeroDeItens(), previousItemsNumber - 5);

    }

    @Test
    void testDelete() {
        Lote resultado = driver.findById(lote.getId()).get();

        driver.deleteById(resultado.getId());

        assertFalse(driver.findById(lote.getId()).isPresent());
    }
}