package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCDemo3 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //定义sql语句
            String sql = "DELETE FROM user WHERE id=49";
            //创建数据库连接对象conn
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
            //创建执行sql对象stetament
            stat = conn.createStatement();
            //执行sql
            int count = stat.executeUpdate(sql);
            //处理结果
            if(count > 0){
                System.out.println("update 执行成功");
            }else {
                System.out.println("update 执行失败");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(stat == null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn == null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
