package com.yangnk.mysqldemo.myTest;

import org.junit.jupiter.api.Test;
import java.sql.*;
import static java.sql.DriverManager.getConnection;

public class MyTest {

    @Test
    public  void test() throws SQLException, ClassNotFoundException {
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            // 1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");

            // 2.创建连接
            conn= getConnection("jdbc:mysql://localhost:3306/test_db", "root", "666666");

            // SQL语句
            String sql="select id,user_name from user1 where id=?";

            // 获得sql执行者
            pstmt=conn.prepareStatement(sql);
            pstmt.setInt(1,1);

            // 执行查询
            //ResultSet rs= pstmt.executeQuery();
            pstmt.execute();
            ResultSet rs= pstmt.getResultSet();

            rs.next();
            User1 user =new User1();
            user.setId(rs.getInt("id"));
            user.setUserName(rs.getString("user_name"));
//            user.setId(rs.getLong("id"));
//            user.setUserName(rs.getString("user_name"));
//            user.setCreateTime(rs.getDate("create_time"));
            System.out.println(user.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            // 关闭资源
            try {
                if(conn!=null){
                    conn.close();
                }
                if(pstmt!=null){
                    pstmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
