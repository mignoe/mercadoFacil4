package com.ufcg.psoft.mercadofacil.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link LoteAlterarPadraoService}.
 */
public class LoteAlterarPadraoService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'loteAlterarPadraoService'.
   */
  public static BeanDefinition getLoteAlterarPadraoServiceBeanDefinition() {
    Class<?> beanType = LoteAlterarPadraoService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<LoteAlterarPadraoService> instanceSupplier = InstanceSupplier.using(LoteAlterarPadraoService::new);
    instanceSupplier = instanceSupplier.andThen(LoteAlterarPadraoService__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
