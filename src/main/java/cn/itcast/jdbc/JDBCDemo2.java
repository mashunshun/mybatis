package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo2 {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;

        //1、注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、定义sql
            String sql = "insert into user values(49,'张三','2018-03-03','男','郑州')";

            //获取Connection对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","123456");

            //获取执行sql的对象Statement
            statement = connection.createStatement();

            //执行sql
            int count = statement.executeUpdate(sql);

            //处理结果
            if(count > 0){
                System.out.println("操作成功");
            }else {
                System.out.println("操作失败");
            }

            //关闭资源
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(connection == null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement == null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
