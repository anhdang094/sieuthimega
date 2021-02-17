package vn.smart.admin.application.configuration.activemq;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
@ComponentScan(basePackages = "vn.smart.admin.infrastructure")
@PropertySource(value = {"classpath:config.properties"})
public class JmsConfig {

  @Autowired
  private Environment env;

  @Bean
  public String queueName() {
    return env.getProperty("app.activemq.subject");
  }

  @Bean
  public ActiveMQConnectionFactory connectionFactory() {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
    connectionFactory.setBrokerURL(env.getProperty("app.activemq.url"));
    connectionFactory.setUserName(env.getProperty("app.activemq.user"));
    connectionFactory.setPassword(env.getProperty("app.activemq.password"));

    return connectionFactory;
  }

  @Bean
  public JmsTemplate jmsTemplate() {
    JmsTemplate template = new JmsTemplate();
    template.setConnectionFactory(connectionFactory());

    return template;
  }

  @Bean
  public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
    DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
    factory.setConnectionFactory(connectionFactory());
    factory.setConcurrency("1-1");
    // true: using jms topic, false: using jms queue
    factory.setPubSubDomain(false);

    return factory;
  }
}
