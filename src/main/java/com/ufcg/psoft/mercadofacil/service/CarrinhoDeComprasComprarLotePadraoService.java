package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;
import com.ufcg.psoft.mercadofacil.repository.CarrinhoRepository;
import com.ufcg.psoft.mercadofacil.repository.LoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service
public class CarrinhoDeComprasComprarLotePadraoService implements CarrinhoDeComprasComprarLoteService {
    @Autowired
    LoteRepository loteRepository;
    @Autowired
    CarrinhoRepository carrinhoRepository;


    @Override
    public void comprarLoteInteiro(Cliente cliente, Long loteId) {
        Lote lote = loteRepository.findById(loteId).orElse(null);

        if (lote == null) {
            throw new RuntimeException("Lote inexistente");
        }

        // Apenas simulando o que seria a compra (mesmo fora desse método)
        Carrinho carrinho = carrinhoRepository.findById(cliente.getCarrinho().getId()).get();
        carrinho.setLote(new HashSet<>());
        carrinho.getLote().add(lote);

        lote.setNumeroDeItens(0);

        // settando lote do carrinho de volta a nulo
        carrinho.getLote().remove(lote);

        loteRepository.save(lote);
    }

    @Override
    public void comprarLoteParcial(Cliente cliente, Long loteId, int qtdItens) {

        Lote lote = loteRepository.findById(loteId).orElse(null);

        if (lote == null) {
            throw new RuntimeException("Lote inexistente");
        }

        if (qtdItens < 0) {
            throw new RuntimeException("Número de itens iválido (negativo)");
        }

        if (lote.getNumeroDeItens() < qtdItens) {
            throw new RuntimeException("Número de itens no lote insuficiente");
        }

        // Apenas simulando o que seria a compra (mesmo fora desse método)
        Carrinho carrinho = carrinhoRepository.findById(cliente.getCarrinho().getId()).get();
        carrinho.setLote(new HashSet<>());
        carrinho.getLote().add(lote);

        lote.setNumeroDeItens(lote.getNumeroDeItens() - qtdItens);

        // settando lote do carrinho de volta a nulo
        carrinho.getLote().remove(lote);

        loteRepository.save(lote);
    }
}
