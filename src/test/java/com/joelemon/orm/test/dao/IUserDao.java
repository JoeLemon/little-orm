package com.joelemon.orm.test.dao;

/**
 * @author HJY
 * @date 2022/8/1
 */
public interface IUserDao {
    String queryUserName(String uId);

    Integer queryUserAge(String uId);
}
