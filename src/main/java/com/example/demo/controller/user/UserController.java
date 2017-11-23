/**
 * 
 */
package com.example.demo.controller.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
  
  static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long,User>());
  
  
  @RequestMapping(value="/",method=RequestMethod.GET)
  public List<User> getUserList(){
    /*User user1 = new User();
    user1.setId(1L);
    user1.setName("隗超");
    user1.setAge(12);
    User user2 = new User();
    user2.setId(2L);
    user2.setName("余丽");
    user2.setAge(25);
    List<User> users = new ArrayList<>();
    users.add(user1);
    users.add(user2);*/
    List<User> u = new ArrayList<>(users.values());
    return u;
  }
  
  @RequestMapping(value="/",method = RequestMethod.POST)
  public String postUser( @ModelAttribute User user){
    users.put(user.getId(), user);
    return "success";
  }
  
  @RequestMapping(value="/{id}",method = RequestMethod.GET)
  public User getUser(@PathVariable Long id){
    return users.get(id);
  }
  
  //更新 put   restful   
  @RequestMapping(value = "{id}",method = RequestMethod.PUT)
  public String putUser(@PathVariable Long id,@ModelAttribute User user){
    User u = users.get(id);
    u.setName(user.getName());
    u.setAge(user.getAge());
    users.put(id, u);
    return "success";
  }
  
  @RequestMapping(value="/{id}",method=RequestMethod.DELETE)
  public String delete(@PathVariable Long id){
     users.remove(id);
     return "success";
  }
  

}
