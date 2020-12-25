package com.example.untils;/**
 * @Auther: http://www.bjsxt.com
 * @Date: 2020/12/4
 * Description: com.example.untils
 * version: 1.0
 */

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.impl.PublicClaims;
import com.example.jwt.JwtPayLoad;
import com.jsoniter.JsonIterator;
import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import sun.rmi.runtime.Log;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 *@ClassName JwtUntils
 *
 *@Author lenovo
 *@Date 2020/12/4 11:10
 *description JwtUntils
 **/
public class JwtUntils {


  //加密算法
  private static final String HEADER_ALG = "HS256";
  //加密算法
  private static final String HEADER_TYPE = "jwt";


  /**
   * 生成token
   * @param jwtPayLoad
   * @return
   */
  public static String generate(JwtPayLoad jwtPayLoad){

    //token由三部分组成：1、header，2、payload，3、sign
    JWTCreator.Builder builder = JWT.create();
          builder.withHeader(getHeader())//头信息
            .withIssuedAt(new Date())//创建时间
            .withExpiresAt(new Date(System.currentTimeMillis()+100000))//过期时间
            //.withIssuer()//颁发者唯一表示，这里不写
            .withJWTId(jwtPayLoad.getId());//jwt的id
    try {
      //将JwtPayLoad中的字段加入builder
      builder = builderClaim(jwtPayLoad, builder);
    } catch (IllegalAccessException e) {
      e.printStackTrace();

    }
    //返回token
    return builder.sign(Algorithm.HMAC256("123456")) ;
  }


  /**
   * 根据token解析出数据
   * @param token
   * @return
   */
  public static String getPayloadStringByToken(String token) throws Exception {

    try {
      //将token以"."分割
      String[] split = token.split("\\.");
      //并获取索引为1的部分，命名为payLoad
      String payLoad=split[1];
      //通过Base64字符串方式解析
      byte[] bytes = Base64.decodeBase64(payLoad);
      return new String(bytes, "UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
      throw new Exception("解析失败，重新登录");
    }
  }

  /**
   * 解析token获取id
   * @param token
   * @return
   * @throws Exception
   */
  public static String getPayLoadId(String token) throws Exception {
    //获取payLoad信息
    String payload = getPayloadStringByToken(token);
    //将payLoad序列化
    JwtPayLoad jwtPayLoad = JsonIterator.deserialize(payload, JwtPayLoad.class);

    return jwtPayLoad.getId();
  }


  /**
   * jwt 头信息加密
   *
   * @return
   */
  private static Map getHeader() {
    Map<String, Object> headerClaims = new HashMap<>(2);
    headerClaims.put(PublicClaims.ALGORITHM, HEADER_ALG);
    headerClaims.put(PublicClaims.TYPE, HEADER_TYPE);
    return headerClaims;
  }



  public static JWTCreator.Builder builderClaim(JwtPayLoad payLoad,JWTCreator.Builder builder) throws IllegalAccessException {

    //通过实体类对象，通过反射获取该实体类的所有字段
    Field[] fields = payLoad.getClass().getDeclaredFields();

    //将字段逐个加入builder
    for (Field field : fields) {
      //字段名
      String name = field.getName();

      // f.setAccessible(true);得作用就是让我们在用反射时访问私有变量
      field.setAccessible(true);
      //获取字段的值
      Object value = field.get(payLoad);

      builder.withClaim(name, (String) value);
    }


    return builder;
  }
}
