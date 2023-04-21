package com.ufcg.psoft.mercadofacil.service;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.InstanceSupplier;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link CarrinhoDeComprasComprarLotePadraoService}.
 */
public class CarrinhoDeComprasComprarLotePadraoService__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'carrinhoDeComprasComprarLotePadraoService'.
   */
  public static BeanDefinition getCarrinhoDeComprasComprarLotePadraoServiceBeanDefinition() {
    Class<?> beanType = CarrinhoDeComprasComprarLotePadraoService.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    InstanceSupplier<CarrinhoDeComprasComprarLotePadraoService> instanceSupplier = InstanceSupplier.using(CarrinhoDeComprasComprarLotePadraoService::new);
    instanceSupplier = instanceSupplier.andThen(CarrinhoDeComprasComprarLotePadraoService__TestContext001_Autowiring::apply);
    beanDefinition.setInstanceSupplier(instanceSupplier);
    return beanDefinition;
  }
}
