package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.CarrinhoRepository;
import com.ufcg.psoft.mercadofacil.repository.ClienteRepository;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CarrinhoDeComprasComprarServiceTests {

    @Autowired
    CarrinhoDeComprasComprarLoteService driver;

    @Autowired
    LoteRepository loteRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    Cliente cliente;

    Lote lote;

    Carrinho carrinho;

    Produto produto;
    @BeforeEach
    void setup() {

        produto = Produto.builder()
                .codigoDeBarras("7899137500100")
                .preco(30.0)
                .nome("Arroz")
                .fabricante("Branquinho")
                .build();

        lote = loteRepository.save(Lote.builder()
                .produto(produto)
                .numeroDeItens(30)
                .build());



        cliente = Cliente.builder()
                .cpf(12345678L)
                .idade(10)
                .endereco("UFCG")
                .carrinho(carrinho)
                .nome("André")
                .build();

        carrinho = Carrinho.builder()
                .cliente(cliente)
                .lote(new HashSet<>())
                .build();

        produto = produtoRepository.save(produto);
        carrinho = carrinhoRepository.save(carrinho);
        cliente = clienteRepository.save(cliente);

        carrinho.setCliente(cliente);
        cliente.setCarrinho(carrinho);
    }

    @AfterEach
    void tearDown() {
        clienteRepository.deleteAll();
        carrinhoRepository.deleteAll();
        loteRepository.deleteAll();
        produtoRepository.deleteAll();
    }

    @Test
    void assertTrue() {
        Assertions.assertTrue(true);
    }

    @Test
    void comprarLoteInteiro() {
        driver.comprarLoteInteiro(cliente, lote.getId());

        Lote resultado = loteRepository.findById(lote.getId()).get();

        assertEquals(resultado.getNumeroDeItens(), 0);
    }

    @Test
    @DisplayName("Comprar lote inexistente inteiro")
    void comprarLoteInexistenteInteiro() {

        RuntimeException thrown = Assertions.assertThrows( RuntimeException.class,
                () -> {
                    driver.comprarLoteInteiro(cliente, lote.getId() + 30L);
                }
        );
        ;

        assertEquals(thrown.getMessage(), "Lote inexistente");
    }

    @Test
    @DisplayName("Quando compro lote parcialmente e o lote não tem itens suficientes")
    void comprarLoteParcialmenteComValorInvalido() {

        RuntimeException thrown = Assertions.assertThrows( RuntimeException.class,
                () -> {
                    driver.comprarLoteParcial(cliente, lote.getId(), 31);
                }
        );

        assertEquals(thrown.getMessage(), "Número de itens no lote insuficiente");
    }

    @Test
    @DisplayName("Quando compro lote parcialmente com quantidade de itens negativa")
    void comprarLoteParcialmenteComValorNegativo() {

        RuntimeException thrown = Assertions.assertThrows( RuntimeException.class,
                () -> {
                    driver.comprarLoteParcial(cliente, lote.getId(), -3);
                }
        );

        assertEquals(thrown.getMessage(), "Número de itens iválido (negativo)");
    }

    @Test
    @DisplayName("Quando compro lote parcialmente com lote inexistente")
    void comprarLoteParcialmenteComLoteInexistente() {

        RuntimeException thrown = Assertions.assertThrows( RuntimeException.class,
                () -> {
                    driver.comprarLoteParcial(cliente, lote.getId() + 30, 3);
                }
        );

        assertEquals(thrown.getMessage(), "Lote inexistente");
    }
}
