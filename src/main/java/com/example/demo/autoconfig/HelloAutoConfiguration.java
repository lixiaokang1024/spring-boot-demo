package com.example.demo.autoconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass({Hello.class})
@EnableConfigurationProperties({HelloProperties.class})
public class HelloAutoConfiguration {

  // @Autowired
  // private HelloProperties helloProperties;

  @Bean
  @ConditionalOnMissingBean(Hello.class)
  @ConfigurationProperties(prefix = "hello")
  public Hello hello(){
    Hello hello = new Hello();
    return hello;
  }
}
