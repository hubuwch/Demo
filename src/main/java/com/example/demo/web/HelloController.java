/**
 * 
 */
package com.example.demo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title  HelloController
 * @author Administrator
 * @date   2017年10月24日上午10:51:55
 */
@RestController
public class HelloController {
  
  @RequestMapping("/hello")
  public String index(){
    return "Hello World!";
  }
  

}
