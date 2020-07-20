package com.example.demo.autoconfig;

public class Hello {

  public Hello(String msg) {
    System.out.println("Hello " + msg);
  }

  public Hello() {
    System.out.println("q");
  }

  private String msg;

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
