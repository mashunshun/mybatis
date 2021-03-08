package cn.itcast.jdbc;

import cn.itcast.doman.User;
import cn.itcast.util.JDBCUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static cn.itcast.util.JDBCUtils.close;

/**
 * 定义一个方法，查询user表的所有数据，封装为对象，然后装载集合，返回
 */
public class JDBCDemo5 {

    public static void main(String[] args) {
        List<User> users = new JDBCDemo5().findAll2();
        System.out.println(users.toString());
        System.out.println(users.size());
    }

    public List<User> findAll(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        //加载驱动
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            //定义sql
            String sql = "select * from user";

            //创建coon连接对象
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","123456");

            //创建stat对象
            statement = connection.createStatement();

            //执行sql
            rs = statement.executeQuery(sql);

            //处理结果
            User user = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String address = rs.getString("address");

                user = new User();

                user.setId(id);
                user.setBirthday(birthday);
                user.setUsername(username);
                user.setSex(sex);
                user.setAddress(address);

                list.add(user);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs != null){
                try {
                    rs.close();
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
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }


    public List<User> findAll2(){
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        List<User> list = new ArrayList<User>();
        //加载驱动
        try {

            //定义sql
            String sql = "select * from user";

            //获取coon连接对象
            connection = JDBCUtils.getCooneciton();
            //创建stat对象
            statement = connection.createStatement();

            //执行sql
            rs = statement.executeQuery(sql);

            //处理结果
            User user = null;
            while (rs.next()){
                int id = rs.getInt("id");
                String username = rs.getString("username");
                Date birthday = rs.getDate("birthday");
                String sex = rs.getString("sex");
                String address = rs.getString("address");

                user = new User();

                user.setId(id);
                user.setBirthday(birthday);
                user.setUsername(username);
                user.setSex(sex);
                user.setAddress(address);

                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,statement,connection);
    }
        return list;
    }
}
