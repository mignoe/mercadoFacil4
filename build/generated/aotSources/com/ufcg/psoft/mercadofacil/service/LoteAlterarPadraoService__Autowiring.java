package com.ufcg.psoft.mercadofacil.service;

import org.springframework.beans.factory.aot.AutowiredFieldValueResolver;
import org.springframework.beans.factory.support.RegisteredBean;

/**
 * Autowiring for {@link LoteAlterarPadraoService}.
 */
public class LoteAlterarPadraoService__Autowiring {
  /**
   * Apply the autowiring.
   */
  public static LoteAlterarPadraoService apply(RegisteredBean registeredBean,
      LoteAlterarPadraoService instance) {
    instance.loteRepository = AutowiredFieldValueResolver.forRequiredField("loteRepository").resolve(registeredBean);
    return instance;
  }
}
