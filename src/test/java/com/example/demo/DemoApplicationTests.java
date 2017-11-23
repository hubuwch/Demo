package com.example.demo;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class DemoApplicationTests {
    @Autowired
    private MockMvc mvc;
    
    @Test
    public void getHello() throws Exception{
      mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
              .andExpect(status().isOk())
              .andExpect(content().string(equalTo("Hello World!")));
    }
    
    @Test
    public void testUserController() throws Exception{
      //测试usercontroller
      MockHttpServletRequestBuilder request = null;
      
      //1、get查user列表
      request = MockMvcRequestBuilders.get("/users/");
      
      mvc.perform(request)
          .andExpect(status().isOk())
          .andExpect(content().string(equalTo("[]")));
      
      
      //2、post 提交user
      //模拟一个带参数的post类型的http请求
      request =MockMvcRequestBuilders.post("/users/")
                                 .param("id", "1")
                                 .param("name", "学习榜样")
                                 .param("age", "20");
      //执行http请求，并指定输出预期结果
      mvc.perform(request)
                        .andExpect(content().string(equalTo("success")));
      
      //3、 get 带参数http请求
      
      request = MockMvcRequestBuilders.get("/users/1");
      
      mvc.perform(request)
                         .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"学习榜样\",\"age\":20}")));
      
      //4、 put  
      request = MockMvcRequestBuilders.put("/users/1")
                                      .param("name", "烽火云创")
                                      .param("age", "30");
      mvc.perform(request)
                         .andExpect(content().string(equalTo("success")));
      
      
      //5、 get 带参数http请求
            
            request = MockMvcRequestBuilders.get("/users/1");
            
            mvc.perform(request)
                               .andExpect(content().string(equalTo("{\"id\":1,\"name\":\"烽火云创\",\"age\":30}")));
      //6、delete 
            request = MockMvcRequestBuilders.delete("/users/1");
            mvc.perform(request)
                               .andExpect(content().string(equalTo("success")))
                               .andReturn();
            
            
     //7、getlist
            request = MockMvcRequestBuilders.get("/users/");
            
            mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("[]")));
                
    }
    


}
