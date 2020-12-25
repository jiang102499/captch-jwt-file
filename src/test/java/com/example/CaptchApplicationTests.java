package com.example;

import com.example.jwt.JwtPayLoad;
import com.example.untils.JwtUntils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CaptchApplicationTests {


  @Test
  void contextLoads() {

    JwtPayLoad jwtPayLoad=new JwtPayLoad();

    jwtPayLoad.setId("1");
    jwtPayLoad.setAccount("123456");
    jwtPayLoad.setPassword("123456");
    String token = JwtUntils.generate(jwtPayLoad);
    System.out.println(token);
  }


  @Test
  void contextLoads2() throws Exception {
    String payloadStringByToken = JwtUntils.getPayloadStringByToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjEyMzQ1NiIsImlkIjoiNDAyOGUwODE3NjI3YzlhYzAxNzYyN2NiNjg4MDAwMDAiLCJleHAiOjE2MDcwNjU2MTAsImlhdCI6MTYwNzA2NTUxMCwianRpIjoiNDAyOGUwODE3NjI3YzlhYzAxNzYyN2NiNjg4MDAwMDAiLCJhY2NvdW50IjoiMTY2MTI1OTM0MCJ9.xOp-c6MQkXpJEJSe2_BjeVteQnH1kElgzU7NjdI9ZOs");
    System.out.println(payloadStringByToken);
  }

}
