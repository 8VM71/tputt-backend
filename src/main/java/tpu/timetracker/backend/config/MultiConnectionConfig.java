package tpu.timetracker.backend.config;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiConnectionConfig {

  @Value("${server.http.port}")
  private int httpDefaultPort;

  @Value("${server.port}")
  private int httpsPort;

  @Bean
  public EmbeddedServletContainerFactory servletContainer() {
    final TomcatEmbeddedServletContainerFactory tomcat = new RedirectTomcatEmbeddedServletContainerFactory();
    tomcat.addAdditionalTomcatConnectors(createSslConnector());
    return tomcat;
  }

  private Connector createSslConnector() {
    final Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
    connector.setScheme("http");
    connector.setPort(httpDefaultPort);
    connector.setSecure(false);
    connector.setRedirectPort(httpsPort);

    return connector;
  }

  private static class RedirectTomcatEmbeddedServletContainerFactory extends TomcatEmbeddedServletContainerFactory {
    @Override
    protected void postProcessContext(Context context) {
      final SecurityConstraint securityConstraint = new SecurityConstraint();
      securityConstraint.setUserConstraint("CONFIDENTIAL");

      final SecurityCollection collection = new SecurityCollection();
      collection.addPattern("/*");
      securityConstraint.addCollection(collection);
      context.addConstraint(securityConstraint);
    }
  }
}
