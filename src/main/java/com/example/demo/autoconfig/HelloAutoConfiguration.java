package com.example.demo.autoconfig;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
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

  static final int hash(Object key) {
    int h;
    return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
  }

  public static void main(String[] args) {
    String[] s = {"5e6ba4752ff36f4c25e23dd9", "5e6bade82ff36f4c25e23ddd", "5e6bbcb92ff36f4c25e23de5", "5e757c172d738a2d3a2d6915",
        "5e757c192d738a2d3a2d691a", "5e75b6af2d738a329d580a37"};
    int n = 16;
    for (int i = 0; i < s.length; i++) {
      int h1 = (n - 1) & hash(s[i]);
      int h2 = (n - 1) & s[i].hashCode();
      System.out.println(s[i].hashCode());
      System.out.println("异或后index=:" + h1);
      System.out.println("index" + h2);
    }
    // for(int i=0;i<5;i++){
    //   ThreadTest t = new ThreadTest();
    //   t.start();
    // }
    // int a = 2;
    // int b = 1;
    // System.out.println(a ^ b);
    // System.out.println(a | b);
    // System.out.println(a & b);
  }

  public static class ThreadTest extends Thread {
    @Override
    public void run() {
      String uuid = UUID.randomUUID().toString().replace("-", "");
      System.out.println(uuid);
      String hostAddress = "";
      try {
        InetAddress addr = InetAddress.getLocalHost();
        hostAddress = addr.getHostAddress();
      } catch (UnknownHostException e) {
        e.printStackTrace();
      }
      long currentThreadId = Thread.currentThread().getId();
      DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS");
      LocalDateTime time = LocalDateTime.now();
      String localTime = df.format(time);
      DateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSSS");
      String currentTimeMillis = sdf.format(new Date());
      List<String> l = new ArrayList<>();
      l.add("as");
      l.add("bd");
      l.add("fgh");
      for (int i = 0; i < l.size(); i++) {
        System.out.println(hostAddress + ":" + currentThreadId + ":" + localTime + ":" + i);
      }
    }
  }
}
