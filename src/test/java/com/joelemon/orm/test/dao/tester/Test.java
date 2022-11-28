package com.joelemon.orm.test.dao.tester;

import com.joelemon.orm.binding.MapperProxyFactory;
import com.joelemon.orm.binding.MapperRegistry;
import com.joelemon.orm.session.SqlSession;
import com.joelemon.orm.session.SqlSessionFactory;
import com.joelemon.orm.session.defaults.DefaultSqlSessionFactory;
import com.joelemon.orm.test.dao.IUserDao;

import java.util.HashMap;
import java.util.Map;

/**
 * @author HJY
 * @date 2022/8/1
 */
public class Test {

    @org.junit.Test
    public void test_MapperProxyFactory() {
        // 1. 注册 Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.joelemon.orm.test.dao");

        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        // 4. 测试验证
        String res = userDao.queryUserName("10001");
        System.out.println("测试结果：" + res);
    }
}
