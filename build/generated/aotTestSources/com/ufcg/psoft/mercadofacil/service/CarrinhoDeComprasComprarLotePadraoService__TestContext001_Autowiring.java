package com.ufcg.psoft.mercadofacil.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link CarrinhoDeComprasComprarLotePadraoService}.
 */
public class CarrinhoDeComprasComprarLotePadraoService__TestContext001_Autowiring {
  /**
   * Apply the autowiring.
   */
  public static CarrinhoDeComprasComprarLotePadraoService apply(RegisteredBean registeredBean,
      CarrinhoDeComprasComprarLotePadraoService instance) {
    instance.loteRepository = AutowiredFieldValueResolver.forRequiredField("loteRepository").resolve(registeredBean);
    instance.carrinhoRepository = AutowiredFieldValueResolver.forRequiredField("carrinhoRepository").resolve(registeredBean);
    return instance;
  }
}
