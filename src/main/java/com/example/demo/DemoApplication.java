package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;

@SpringBootApplication
public class DemoApplication {

  public static void main(String[] args) {
    // configCustomProperties();
    SpringApplication.run(DemoApplication.class, args);
  }

  /**
   * 配置自定义 properties 属性
   */
  private static void configCustomProperties() {
    String filePath = "classpath:/config/custom.properties";
    String scl = System.getProperty("spring.config.location");
    if (StringUtils.hasText(scl)) {
      scl = String.format("%s,%s", filePath, scl);
    } else {
      scl = filePath;
    }
    System.setProperty("spring.config.location", scl);
  }
}
