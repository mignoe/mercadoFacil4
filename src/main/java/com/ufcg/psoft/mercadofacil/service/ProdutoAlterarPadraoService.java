package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Produto;
import com.ufcg.psoft.mercadofacil.repository.ProdutoRepository;
import com.ufcg.psoft.mercadofacil.verifiers.ProdutoValidaCodigoDeBarrasEAN13;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoAlterarPadraoService implements ProdutoAlterarService {
    @Autowired
    ProdutoRepository produtoRepository;

    private ProdutoValidaCodigoDeBarrasEAN13 validadorCodigoDeBarrasEAN13 = new ProdutoValidaCodigoDeBarrasEAN13();
    @Override
    public Produto alterar(Produto produtoAlterado) {
        if (produtoAlterado.getNome() == null
                ||produtoAlterado.getNome().equals("")) {
            throw new RuntimeException("Nome inválido");
        }

        if (produtoAlterado.getFabricante() == null
                || produtoAlterado.getFabricante().equals("")
        ) {
            throw new RuntimeException("Fabricante inválido");
        }

        if (produtoAlterado.getPreco() <= 0) {
            throw new RuntimeException("Preço inválido");
        }


        if (!validadorCodigoDeBarrasEAN13.validaCodigoDeBarras(produtoAlterado.getCodigoDeBarras())) {
            throw new RuntimeException("Código de barras inválido");
        }

        return produtoRepository.save(produtoAlterado);
    }
}
