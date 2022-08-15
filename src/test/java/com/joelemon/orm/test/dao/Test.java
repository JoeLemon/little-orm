package com.joelemon.orm.test.dao;

import com.joelemon.orm.binding.MapperProxyFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HJY
 * @date 2022/8/1
 */
public class Test {

    @org.junit.Test
    public void test_MapperProxyFactory() {
        MapperProxyFactory<com.joelemon.orm.test.dao.IUserDao> factory = new MapperProxyFactory<>(com.joelemon.orm.test.dao.IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("com.joelemon.orm.test.dao.IUserDao.queryUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.joelemon.orm.test.dao.IUserDao.queryUserAge", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        com.joelemon.orm.test.dao.IUserDao userDao = factory.newInstance(sqlSession);

        String res = userDao.queryUserName("10001");
        System.out.printf("测试结果：%s", res);
    }
}
