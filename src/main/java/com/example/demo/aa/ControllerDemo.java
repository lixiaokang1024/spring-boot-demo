package com.example.demo.aa;

import com.example.demo.autoconfig.Hello;
import com.zaxxer.hikari.HikariDataSource;
import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerDemo {

  @Autowired
  private SortingCodeInfoDao sortingCodeInfoDao;

  @Autowired
  private DataSourceAutoConfiguration dataSourceAutoConfiguration;
  @Autowired
  private DataSourceProperties dataSourceProperties;
  @Autowired
  private DataSource dataSource;

  @Autowired
  private Hello hello;

  @Autowired
  private StringRedisTemplate stringRedisTemplate;

  @Value("${spring.redis.host}")
  private String redisUrl;

  @Value("${demo.database.host}")
  private String demoUrl;

  @Value("${spring.datasource.url}")
  private String datasourceUrl;

  @GetMapping("/hello")
  @ResponseBody
  public String hello() throws SQLException {
    System.out.println(redisUrl);
    System.out.println(demoUrl);
    System.out.println(datasourceUrl);
    stringRedisTemplate.opsForValue().set("lxk", "000");
    stringRedisTemplate.opsForHash().put("sync_ka_return_parcel", "pno", "store_id");
    System.out.println(stringRedisTemplate.opsForHash().get("sync_ka_return_parcel", "pno"));
    SortingCodeInfo sortingCodeInfo = new SortingCodeInfo();
    sortingCodeInfo.setPno("123");
    sortingCodeInfo.setSortingCode("000");
    sortingCodeInfo.setLineCode("111");
    System.out.println(dataSource instanceof HikariDataSource);
    Connection connection = dataSource.getConnection();
    PreparedStatement preparedStatement = connection.prepareStatement("select * from sorting_code_info");
    ResultSet resultSet = preparedStatement.executeQuery();
    while (resultSet.next()) {
      System.out.println(resultSet.getString("pno"));
    }
    connection.close();
    dataSourceAutoConfiguration.hashCode();
    dataSourceProperties.hashCode();
    sortingCodeInfoDao.insert(sortingCodeInfo);
    return "Hello Spring Boot msg=" + hello.getMsg();
  }

}
