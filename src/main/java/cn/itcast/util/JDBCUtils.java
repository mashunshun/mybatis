package cn.itcast.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

public class JDBCUtils {
    //定义资源文件的变量
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    /**
     * 因为只加载一次即可拿到这些值，所以使用静态代码块，静态代码块只在类被加载的时候执行一次
     */
    static {
        //读取资源文件获取值
        try {
            //创建properties集合类
            Properties properties = new Properties();
            //获取src路径下的文件方式---->ClassLoader  ；类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();//获取类加载器对象
            URL url1 = classLoader.getResource("jdbc.properties");
            //加载文件
            String path = url1.getPath();
            System.out.println(path);
            properties.load(new FileReader(path));
            //获取数据、赋值
            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            //注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建connection连接对象
     * @return connection
     */
    public static Connection getCooneciton() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源的方法stat and conn
     * @param statement
     * @param connection
     */
    public static void close(Statement statement , Connection connection){
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 释放资源的方法 resu and stat and conn
     * @param resultSet
     * @param statement
     * @param connection
     */
    public static void close(ResultSet resultSet , Statement statement , Connection connection){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
