/**
 * 
 */
package com.example.demo.web;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @title  HelloController
 * @author Administrator
 * @date   2017年10月24日上午10:51:55
 */
@Controller
public class HelloController {
  
  @RequestMapping("/hello")
  public String index(Model model){
    model.addAttribute("name", "张三");
    return "index";
  }
  

}
