package com.joelemon.orm.binding;

import cn.hutool.db.Session;
import com.joelemon.orm.session.SqlSession;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * 代理工厂
 * @author HJY
 * @date 2022/8/1
 */
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession session) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(session.getClass());
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(),
                new Class[]{mapperInterface}, mapperProxy);
    }
}
