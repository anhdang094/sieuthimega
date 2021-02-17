package vn.smart.web.application.configuration.database;

import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@PropertySource({"classpath:database.properties"})
@EnableJpaRepositories(basePackages = "vn.smart.web.domain.repository",
    entityManagerFactoryRef = "shopEntityManager",
    transactionManagerRef = "shopTransactionManager")
public class MySqlConfig {

  @Autowired
  private Environment env;

  @Primary
  @Bean
  public LocalContainerEntityManagerFactoryBean shopEntityManager() {
    LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource());
    em.setPackagesToScan(new String[]{"vn.smart.web.domain.model"});

    HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
    em.setJpaVendorAdapter(vendorAdapter);
    HashMap<String, Object> properties = new HashMap<>();
    properties.put("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
    properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
    properties.put("hibernate.naming-strategy", "org.hibernate.cfg.ImprovedNamingStrategy");

    em.setJpaPropertyMap(properties);

    return em;
  }

  @Primary
  @Bean
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName(env.getProperty("smart-market.driverClassName"));
    dataSource.setUrl(env.getProperty("smart-market.url"));
    dataSource.setUsername(env.getProperty("smart-market.username"));
    dataSource.setPassword(env.getProperty("smart-market.password"));
    return dataSource;
  }

  @Primary
  @Bean
  public PlatformTransactionManager shopTransactionManager() {
    JpaTransactionManager shopTransactionManager = new JpaTransactionManager();
    shopTransactionManager.setEntityManagerFactory(shopEntityManager().getObject());
    return shopTransactionManager;
  }
}
