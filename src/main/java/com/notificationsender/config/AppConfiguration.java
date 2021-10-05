package com.notificationsender.config;

import com.notificationsender.event.handler.EventHandlerFactory;
import com.notificationsender.event.provider.NotificationProviderFactory;
import java.util.Properties;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.config.ServiceLocatorFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

  @Bean
  public ServiceLocatorFactoryBean eventHandlerFactoryBean() {
    ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
    serviceLocatorFactoryBean.setServiceLocatorInterface(EventHandlerFactory.class);
    return serviceLocatorFactoryBean;
  }

  @Bean
  public EventHandlerFactory eventHandlerFactory() {
    return (EventHandlerFactory) eventHandlerFactoryBean().getObject();
  }
  @Bean
  public ServiceLocatorFactoryBean notificationProviderFactoryBean() {
    ServiceLocatorFactoryBean serviceLocatorFactoryBean = new ServiceLocatorFactoryBean();
    serviceLocatorFactoryBean.setServiceLocatorInterface(NotificationProviderFactory.class);
    return serviceLocatorFactoryBean;
  }

  @Bean
  public NotificationProviderFactory notificationProviderFactory() {
    return (NotificationProviderFactory) notificationProviderFactoryBean().getObject();
  }

  @Bean
  public VelocityEngine velocityEngine() throws Exception {
    Properties properties = new Properties();
    properties.setProperty("input.encoding", "UTF-8");
    properties.setProperty("output.encoding", "UTF-8");
    properties.setProperty("resource.loader", "class");
    properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
    VelocityEngine velocityEngine = new VelocityEngine(properties);
    return velocityEngine;
  }
}
