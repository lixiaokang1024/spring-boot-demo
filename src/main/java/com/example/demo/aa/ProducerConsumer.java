package com.example.demo.aa;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

  private static final int MAX_SIZE = 10;
  private static final String LOCK = "LOCK";

  public static void main(String[] args) {
    List<String> datas = new ArrayList<>();
    Thread t1 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          synchronized (LOCK) {
            if (datas.size() > MAX_SIZE) {
              try {
                LOCK.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
            datas.add(String.valueOf(i));
            System.out.println("produce : " + i + ", datas = " + datas.toString());
            LOCK.notifyAll();
          }
        }
      }
    };
    Thread t2 = new Thread() {
      @Override
      public void run() {
        for (int i = 0; i < 100; i++) {
          synchronized (LOCK) {
            if (datas.size() <= 0) {
              try {
                LOCK.wait();
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            }
            datas.remove(String.valueOf(i));
            System.out.println("consumer : " + i + ", datas = " + datas.toString());
            LOCK.notifyAll();
          }
        }
      }
    };
    t1.start();
    t2.start();
  }

}
