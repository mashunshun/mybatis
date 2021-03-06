package com.itheima.mybatis.sqlSession;

/**
 * 自定义mybatis中和数据库交互的核心类
 * 它里面可以创建dao接口的代理对象
 */
public interface SqlSession {
    /**
     * 该方法根据参数创建一个代理对象
     * @param daoInterfaceClass daoInterface字节码
     * @param <T>
     * @return 返回创建的代理对象
     */
    <T> T getMapper(Class<T> daoInterfaceClass);

    void close();
}
