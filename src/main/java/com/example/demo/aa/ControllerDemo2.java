package com.example.demo.aa;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemo2 {

  @GetMapping("/hello2")
  @ResponseBody
  public String hello(){
    return "Hello Spring Boot2";
  }

}
