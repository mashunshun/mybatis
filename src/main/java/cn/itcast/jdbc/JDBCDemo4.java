package cn.itcast.jdbc;

import java.sql.*;

public class JDBCDemo4 {
    public static void main(String[] args) {

        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        //注册驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //定义sql语句
            String sql = "select * FROM user";
            //创建数据库连接对象conn
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "123456");
            //创建执行sql对象stetament
            stat = conn.createStatement();
            //执行sql,并创建结果集对象
            rs = stat.executeQuery(sql);
            //处理结果
            while(rs.next()){
                int id = rs.getInt(1);
                String username = rs.getString("username");
                System.out.println("id:"+id+"-------"+"username"+username);
            }



           /* rs.next();
            int id = rs.getInt(1);
            String username = rs.getString("username");
            System.out.println("id:"+id+"-------"+"username"+username);*/
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //关闭资源
            if(rs != null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(stat != null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
