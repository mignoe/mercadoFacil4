package org.springframework.test.context.aot;

import com.ufcg.psoft.mercadofacil.MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer;
import java.lang.Class;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * Generated mappings for {@link AotTestContextInitializers}.
 */
public class AotTestContextInitializers__Generated {
  public static Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> getContextInitializers(
      ) {
    Map<String, Supplier<ApplicationContextInitializer<? extends ConfigurableApplicationContext>>> map = new HashMap<>();
    map.put("com.ufcg.psoft.mercadofacil.MercadoFacilApplicationTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.repository.CarrinhoDeComprasRepositoryTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.repository.ClienteRepositoryTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.repository.LoteRepositoryTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.repository.ProdutoRepositoryTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.service.CarrinhoDeComprasComprarServiceTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.service.LoteAlterarServiceTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.service.ProdutoAlterarServiceTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.service.ProdutoAlterarServiceTests$AtributosAusentsTests", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    map.put("com.ufcg.psoft.mercadofacil.service.ProdutoAlterarServiceTests$CodigoDeBarras", () -> new MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer());
    return map;
  }

  public static Map<String, Class<? extends ApplicationContextInitializer<?>>> getContextInitializerClasses(
      ) {
    Map<String, Class<? extends ApplicationContextInitializer<?>>> map = new HashMap<>();
    map.put("com.ufcg.psoft.mercadofacil.MercadoFacilApplicationTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.repository.CarrinhoDeComprasRepositoryTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.repository.ClienteRepositoryTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.repository.LoteRepositoryTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.repository.ProdutoRepositoryTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.service.CarrinhoDeComprasComprarServiceTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.service.LoteAlterarServiceTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.service.ProdutoAlterarServiceTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.service.ProdutoAlterarServiceTests$AtributosAusentsTests", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    map.put("com.ufcg.psoft.mercadofacil.service.ProdutoAlterarServiceTests$CodigoDeBarras", MercadoFacilApplicationTests__TestContext001_ApplicationContextInitializer.class);
    return map;
  }
}
