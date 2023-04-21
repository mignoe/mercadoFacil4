package org.springframework.boot.autoconfigure.flyway;

import java.lang.Class;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.aot.BeanInstanceSupplier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.core.io.ResourceLoader;

/**
 * Bean definitions for {@link FlywayAutoConfiguration}.
 */
public class FlywayAutoConfiguration__TestContext001_BeanDefinitions {
  /**
   * Get the bean definition for 'flywayAutoConfiguration'.
   */
  public static BeanDefinition getFlywayAutoConfigurationBeanDefinition() {
    Class<?> beanType = FlywayAutoConfiguration.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(FlywayAutoConfiguration::new);
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'stringOrNumberMigrationVersionConverter'.
   */
  private static BeanInstanceSupplier<FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter> getStringOrNumberMigrationVersionConverterInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter>forFactoryMethod(FlywayAutoConfiguration.class, "stringOrNumberMigrationVersionConverter")
            .withGenerator((registeredBean) -> registeredBean.getBeanFactory().getBean(FlywayAutoConfiguration.class).stringOrNumberMigrationVersionConverter());
  }

  /**
   * Get the bean definition for 'stringOrNumberMigrationVersionConverter'.
   */
  public static BeanDefinition getStringOrNumberMigrationVersionConverterBeanDefinition() {
    Class<?> beanType = FlywayAutoConfiguration.StringOrNumberToMigrationVersionConverter.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getStringOrNumberMigrationVersionConverterInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Get the bean instance supplier for 'flywayDefaultDdlModeProvider'.
   */
  private static BeanInstanceSupplier<FlywaySchemaManagementProvider> getFlywayDefaultDdlModeProviderInstanceSupplier(
      ) {
    return BeanInstanceSupplier.<FlywaySchemaManagementProvider>forFactoryMethod(FlywayAutoConfiguration.class, "flywayDefaultDdlModeProvider", ObjectProvider.class)
            .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FlywayAutoConfiguration.class).flywayDefaultDdlModeProvider(args.get(0)));
  }

  /**
   * Get the bean definition for 'flywayDefaultDdlModeProvider'.
   */
  public static BeanDefinition getFlywayDefaultDdlModeProviderBeanDefinition() {
    Class<?> beanType = FlywaySchemaManagementProvider.class;
    RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
    beanDefinition.setInstanceSupplier(getFlywayDefaultDdlModeProviderInstanceSupplier());
    return beanDefinition;
  }

  /**
   * Bean definitions for {@link FlywayAutoConfiguration.FlywayConfiguration}.
   */
  public static class FlywayConfiguration__BeanDefinitions {
    /**
     * Get the bean definition for 'flywayConfiguration'.
     */
    public static BeanDefinition getFlywayConfigurationBeanDefinition() {
      Class<?> beanType = FlywayAutoConfiguration.FlywayConfiguration.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(FlywayAutoConfiguration.FlywayConfiguration::new);
      return beanDefinition;
    }

    /**
     * Get the bean instance for 'resourceProviderCustomizer'.
     */
    private static NativeImageResourceProviderCustomizer getResourceProviderCustomizerInstance() {
      return new NativeImageResourceProviderCustomizer();
    }

    /**
     * Get the bean definition for 'resourceProviderCustomizer'.
     */
    public static BeanDefinition getResourceProviderCustomizerBeanDefinition() {
      Class<?> beanType = ResourceProviderCustomizer.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(FlywayConfiguration__BeanDefinitions::getResourceProviderCustomizerInstance);
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'flyway'.
     */
    private static BeanInstanceSupplier<Flyway> getFlywayInstanceSupplier() {
      return BeanInstanceSupplier.<Flyway>forFactoryMethod(FlywayAutoConfiguration.FlywayConfiguration.class, "flyway", FlywayProperties.class, ResourceLoader.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ObjectProvider.class, ResourceProviderCustomizer.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FlywayAutoConfiguration.FlywayConfiguration.class).flyway(args.get(0), args.get(1), args.get(2), args.get(3), args.get(4), args.get(5), args.get(6), args.get(7)));
    }

    /**
     * Get the bean definition for 'flyway'.
     */
    public static BeanDefinition getFlywayBeanDefinition() {
      Class<?> beanType = Flyway.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setInstanceSupplier(getFlywayInstanceSupplier());
      return beanDefinition;
    }

    /**
     * Get the bean instance supplier for 'flywayInitializer'.
     */
    private static BeanInstanceSupplier<FlywayMigrationInitializer> getFlywayInitializerInstanceSupplier(
        ) {
      return BeanInstanceSupplier.<FlywayMigrationInitializer>forFactoryMethod(FlywayAutoConfiguration.FlywayConfiguration.class, "flywayInitializer", Flyway.class, ObjectProvider.class)
              .withGenerator((registeredBean, args) -> registeredBean.getBeanFactory().getBean(FlywayAutoConfiguration.FlywayConfiguration.class).flywayInitializer(args.get(0), args.get(1)));
    }

    /**
     * Get the bean definition for 'flywayInitializer'.
     */
    public static BeanDefinition getFlywayInitializerBeanDefinition() {
      Class<?> beanType = FlywayMigrationInitializer.class;
      RootBeanDefinition beanDefinition = new RootBeanDefinition(beanType);
      beanDefinition.setDependsOn("flyway");
      beanDefinition.setInstanceSupplier(getFlywayInitializerInstanceSupplier());
      return beanDefinition;
    }
  }
}
