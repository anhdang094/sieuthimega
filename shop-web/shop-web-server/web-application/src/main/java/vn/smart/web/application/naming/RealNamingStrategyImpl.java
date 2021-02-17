package vn.smart.web.application.naming;

import java.io.Serializable;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class RealNamingStrategyImpl extends org.springframework.boot.orm.jpa.hibernate.SpringPhysicalNamingStrategy implements Serializable {

  @Override
  public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
    return new Identifier(name.getText(), name.isQuoted());
  }

  @Override
  public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment context) {
    return new Identifier(name.getText(), name.isQuoted());
  }
}

