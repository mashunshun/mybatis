package com.itheima.dao;

import com.itheima.doman.User;

import java.util.List;

/**
 * 用户的持久层接口
 */
public interface IUserDao {

    /**
     * findAll查询所有操作
     */
    List<User> findAll();
}
