package com.joelemon.orm.binding;

import com.joelemon.orm.session.SqlSession;
import com.sun.deploy.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

/**
 * orm代理
 * @author HJY
 * @date 2022/8/1
 */
public class MapperProxy<T> implements InvocationHandler, Serializable {

    private static final long serialVersionUID = -1L;
    private Class<T> mapperInterface;
    public MapperProxy(Class mapperIf) {
        mapperInterface = mapperIf;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(this, args);
        } else {
            return "\n代理方法执行：" + (mapperInterface.getName() + "." + method.getName())
                    + "\n代理方法参数：" + Arrays.asList(args).stream().map(item -> String.valueOf(item))
                    .collect(Collectors.joining("\n"));
        }
    }
}
