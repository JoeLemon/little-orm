package com.joelemon.orm.session.defaults;

import com.joelemon.orm.binding.MapperRegistry;
import com.joelemon.orm.session.SqlSession;

/**
 * SqlSession、DefaultSqlSession 用于定义执行 SQL 标准、获取映射器以及将来管理事务等方面的操作。
 * 基本我们平常使用 Mybatis 的 API 接口也都是从这个接口类定义的方法进行使用的。
 */
public class DefaultSqlSession implements SqlSession {

    /**
     * 映射器注册机
     */
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

}
