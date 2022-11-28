package com.joelemon.orm.session.defaults;

import com.joelemon.orm.binding.MapperRegistry;
import com.joelemon.orm.session.SqlSession;
import com.joelemon.orm.session.SqlSessionFactory;

public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }

}
