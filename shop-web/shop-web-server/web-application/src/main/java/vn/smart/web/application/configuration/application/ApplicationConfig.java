package vn.smart.web.application.configuration.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import vn.smart.web.application.configuration.base.AccessInfo;
import vn.smart.web.application.configuration.base.ApplicationInfo;

@Configuration
@PropertySource(value = {"classpath:config.properties"})
public class ApplicationConfig {

  @Autowired
  private Environment env;

  @Bean
  AccessInfo getAccessInfo() {
    AccessInfo accessInfo = new AccessInfo();
    accessInfo.setServletPath(env.getProperty("server.servlet.path"));
    accessInfo.setApiKeys(env.getProperty("access.info.api-keys"));
    accessInfo.setEnv(env.getProperty("app.enviroment"));
    return accessInfo;
  }

  @Bean
  ApplicationInfo getApplicationInfo() {
    ApplicationInfo applicationInfo = new ApplicationInfo();
    applicationInfo.setApiKey(env.getProperty("app.api-key"));
    return applicationInfo;
  }
}
