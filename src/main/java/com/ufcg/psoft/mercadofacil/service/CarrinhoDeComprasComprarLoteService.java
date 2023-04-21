package com.ufcg.psoft.mercadofacil.service;

import com.ufcg.psoft.mercadofacil.model.Carrinho;
import com.ufcg.psoft.mercadofacil.model.Cliente;
import com.ufcg.psoft.mercadofacil.model.Lote;

public interface CarrinhoDeComprasComprarLoteService {
    void comprarLoteInteiro(Cliente cliente, Long loteId);

    void comprarLoteParcial(Cliente cliente, Long loteId, int qtdItens);

}
