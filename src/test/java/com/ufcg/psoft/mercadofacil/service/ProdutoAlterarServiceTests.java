package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@DisplayName("Testes do Serviço de alteração do produto")
public class ProdutoAlterarServiceTests {

    @Autowired
    ProdutoAlterarService driver;

    @Autowired
    ProdutoRepository produtoRepository;

    Produto produto;

    @BeforeEach
    void setup() {
        produto = produtoRepository.save(Produto.builder()
                .codigoDeBarras("7899137500100")
                .nome("Produto Dez")
                .fabricante("Empresa Dez")
                .preco(450.00)
                .build()
        );
    }

    @AfterEach
    void tearDown() {
        produtoRepository.deleteAll();
    }

    @Test
    @DisplayName("Quando um novo nome válido for fornecido para o produto")
    void quandoNovoNomeValido() {
        // Arrange
        produto.setNome("Produto Dez Atualizado");

        // Act
        Produto resultado = driver.alterar(produto);

        // Assert
        assertEquals("Produto Dez Atualizado", resultado.getNome());
    }

    @Test
    @DisplayName("Quando altero o fabricante do produto com um fabricante válido")
    void alterarFabricanteDoProduto() {
        /* AAA */
        //Arrange
        produto.setFabricante("Empresa Dez");
        //Act
        Produto resultado = driver.alterar(produto);
        //Assert
        assertEquals("Empresa Dez", resultado.getFabricante());
    }

    @Test
    @DisplayName("Quando altero o preço do produto com um valor válido")
    void alterarPrecoDoProduto() {
        /* AAA */
        //Arrange
        produto.setPreco(450.0);
        //Act
        Produto resultado = driver.alterar(produto);
        //Assert
        assertEquals(450.0, resultado.getPreco());
    }

    @Nested
    @DisplayName("Quando altero o produto com atributo(s) ausentes")
    class AtributosAusentsTests {
        @Test
        @DisplayName("Quando altero o produto com nome vazio")
        void alterarProdutoFaltandoNome() {
            /* AAA */
            //Arrange
            produto.setNome("");
            //Act

            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Nome inválido", thrown.getMessage());

        }

        @Test
        @DisplayName("Quando altero o produto com fabricante ausente")
        void alterarProdutoFaltandoFabricante() {
            /* AAA */
            //Arrange
            produto.setFabricante("");
            //Act

            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Fabricante inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando altero o produto com código de barras ausente")
        void alterarProdutoFaltandoCodigoDeBarras() {
            /* AAA */
            //Arrange
            produto.setCodigoDeBarras("");
            //Act

            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando altero o produto com nome nulo")
        void alterarProdutoNomeNulo() {
            /* AAA */
            //Arrange
            produto.setNome(null);
            //Act

            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Nome inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando altero o produto com fabricante ausente")
        void alterarProdutoFabricanteNulo() {
            /* AAA */
            //Arrange
            produto.setFabricante(null);
            //Act

            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Fabricante inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando altero o produto com código de barras ausente")
        void alterarProdutoCodigoDeBarrasNulo() {
            /* AAA */
            //Arrange
            produto.setCodigoDeBarras(null);
            //Act

            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());
        }

    }

    @Test
    @DisplayName("Quando o preço é menor ou igual a zero")
    void precoMenorIgualAZero() {
        /* AAA */
        //Arrange
        produto.setPreco(0.00);
        //Act

        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                () -> driver.alterar(produto)
        );

        //Assert
        assertEquals("Preço inválido", thrown.getMessage());
    }

    @Nested
    @DisplayName("Testes envolvendo código de barras")
    class CodigoDeBarras {
        @Test
        @DisplayName("Quando o código de barras é válido")
        void mudarCodigoDeBarras () {
            /* AAA */
            //Arrange
            produto.setCodigoDeBarras("7899137503217");
            //Act
            Produto resultado = driver.alterar(produto);
            //Assert
            assertEquals(resultado.getCodigoDeBarras(), "7899137503217");
        }

        @Test
        @DisplayName("Quando o código de barras é inválido (dígito de verificação errado)")
        void mudarCodigoDeBarrasParaDigitoDeVerificacaoInvalido () {
            /* AAA */
            //Arrange
            // O dígito de verificação está errado.
            produto.setCodigoDeBarras("7899137578902");
            //Act
            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando o código de barras é inválido (número de dígitos menor que 13)")
        void mudarCodigoDeBarrasParaTamanhoMenor () {
            /* AAA */
            //Arrange

            produto.setCodigoDeBarras("789");
            //Act
            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando o código de barras é inválido (número de dígitos maior que 13)")
        void mudarCodigoDeBarrasParaTamanhoMaior () {
            /* AAA */
            //Arrange
            // Código de verificação está correto (considerando os 13 primeiros dígitos).
            produto.setCodigoDeBarras("78991375001041123");
            //Act
            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());

            /* AAA */
            //Arrange
            // Codigo de verificação incorreto .
            produto.setCodigoDeBarras("78991375001051123");
            //Act
            RuntimeException thrown2 = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown2.getMessage());
        }

        @Test
        @DisplayName("Quando o código de barras é de outro país")
        void mudarCodigoDeBarrasParaOutraNacao () {
            /* AAA */
            //Arrange
            produto.setCodigoDeBarras("7809137500109");
            //Act
            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());
        }

        @Test
        @DisplayName("Quando o código de barras é de outra empresa")
        void mudarCodigoDeBarrasParaOutraEmpresa () {
            /* AAA */
            //Arrange
            produto.setCodigoDeBarras("7899538900103");
            //Act
            RuntimeException thrown = assertThrows(
                    RuntimeException.class,
                    () -> driver.alterar(produto)
            );

            //Assert
            assertEquals("Código de barras inválido", thrown.getMessage());
        }


    }

}
