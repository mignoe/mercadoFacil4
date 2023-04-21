package org.springframework.boot.autoconfigure.flyway;

import java.lang.Class;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;

/**
 * Bean definitions for {@link FlywayProperties}.
 */
public class FlywayProperties__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'flywayProperties'.
   */
  public static BeanDefinition getFlywayPropertiesBeanDefinition() {
    Class<?> beanType = FlywayProperties.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(FlywayProperties::new);
    return beanDefinition;
  }
}
