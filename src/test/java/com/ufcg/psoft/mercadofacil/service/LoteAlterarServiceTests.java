package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class LoteAlterarServiceTests {

    @Autowired
    LoteAlterarService driver;

    @Autowired
    LoteRepository loteRepository;

    Lote lote;

    Produto produto;

    @Autowired
    ProdutoRepository produtoRepository;

    @BeforeEach
    void setup() {
        lote = loteRepository.save(Lote.builder()
                .produto(Produto.builder()
                        .codigoDeBarras("7899137500100")
                        .nome("Produto Dez")
                        .fabricante("Empresa Dez")
                        .preco(450.00)
                        .build())
                .numeroDeItens(30)
                .build()
        );
    }

    @AfterEach
    void tearDown() {
        loteRepository.deleteAll();
        produtoRepository.deleteAll();
    }

    @Test
    void testTrue() {
        assertTrue(true);
    }

    @Test
    void testAlterarLoteValido(){

        lote.setNumeroDeItens(lote.getNumeroDeItens() - 5);

        Lote resultado = driver.alterar(lote);

        assertEquals(25, resultado.getNumeroDeItens());
    }

    @Test
    @DisplayName("Quando altero o lote com número de itens inválido")
    void testAlterarLoteNumeroInvalido() {

        lote.setNumeroDeItens(-2);

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> driver.alterar(lote)
        );

        assertEquals(thrown.getMessage(), "Número de itens inválido");
    }

    @Test
    @DisplayName("Quando altero o lote com produto inválido")
    void testAlterarLoteProdutoInvalido() {

        lote.setProduto(null);

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> driver.alterar(lote)
        );

        assertEquals(thrown.getMessage(), "Produto do lote inválido");
    }
}
