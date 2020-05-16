package com.example.demo.aa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class DemoRunner implements CommandLineRunner {

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("DemoRunner run.......");

    for (int i = 0; i < 150; i++) {
      RunTask runnable = new RunTask(stringRedisTemplate);
      Thread t = new Thread(runnable);
      t.start();
    }
  }

  private class RunTask implements Runnable {
    private StringRedisTemplate stringRedisTemplate;

    public RunTask(StringRedisTemplate stringRedisTemplate) {
      this.stringRedisTemplate = stringRedisTemplate;
    }

    @Override
    public void run() {
      Long increment = this.stringRedisTemplate.boundValueOps("ABC").increment(1);
      String pno = PnoGenerateUtil.generatePno(increment, "BJ", "000");
      System.out.println("Thread " + Thread.currentThread().getName() + " pno=" + pno);
    }
  }

}
