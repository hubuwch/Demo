/**
 * 
 */
package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entry.User;

/**
 * @title  UserController
 * @author Administrator
 * @date   2017年10月26日下午8:42:01
 */
@RestController
@RequestMapping(value="/users")
public class UserController {
  
  @RequestMapping(value="/",method=RequestMethod.GET)
  public List<User> getUserList(){
    User user1 = new User();
    user1.setId(1L);
    user1.setName("隗超");
    user1.setAge(12);
    User user2 = new User();
    user2.setId(2L);
    user2.setName("余丽");
    user2.setAge(25);
    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);
    return users;
  }
  
  
  

}
