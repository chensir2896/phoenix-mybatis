package com.phoenix;


import java.sql.*;
import java.util.Properties;

/**
 * @ClassName PhoenixDemo
 * @Description https://blog.csdn.net/d6619309/article/details/50358675
 * @Date 2019/7/18 9:56
 * @Version 1.0
 */
public class PhoenixDemo {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Properties properties = new Properties();
        properties.setProperty("phoenix.query.timeoutMs","1200000");
        properties.setProperty("hbase.rpc.timeout","1200000");
        properties.setProperty("hbase.client.scanner.timeout.period","1200000");
        Class.forName("org.apache.phoenix.jdbc.PhoenixDriver");
        //jdbc:phoenix [ :<zookeeper quorum> [ :<port number> [ :<root node> [ :<principal> [ :<keytab file> ] ] ] ] ]
        Connection connection = DriverManager.getConnection("jdbc:phoenix:192.168.5.101:2181:/hbase",properties);
//        Connection connection = DriverManager.getConnection("jdbc:phoenix:192.168.5.101:2181/hbase");

        PreparedStatement ps = connection.prepareStatement("select * from person limit 100");

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            //id,name,age,sex
            int id = resultSet.getInt("id");
            int age = resultSet.getInt("age");
            String name = resultSet.getString("name");
            String sex = resultSet.getString("sex");
            System.out.println("id:"+id+"\tname:"+name+"\tage:"+age+"\tsex:"+sex);
        }

        resultSet.close();
        ps.close();
        connection.close();
    }
}
