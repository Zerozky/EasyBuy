package com.jit.zky.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DataSourceUtil
{
    private static DataSource dataSource;
    private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    /**
     * 读取配置文件 生成数据源
     */
    static
    {

        try (InputStream inputStream = DataSourceUtil.class.getClassLoader().getResourceAsStream("database.properties");)
        {

            Properties proerties = new Properties();
            proerties.load(inputStream);
            dataSource = DruidDataSourceFactory.createDataSource(proerties);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据源
     * @return
     */
    public static DataSource getDataSource()
    {
        return dataSource;
    }

    /**
     * 获取数据库连接
     * @return
     * @throws SQLException 
     */
    public static Connection getConnection() throws SQLException
    {
        Connection conn = tl.get();
        if (conn == null)
        {
            conn = dataSource.getConnection();
            tl.set(conn);
        }
        return conn;
    }

    /**
     * 开启事务
     * @throws SQLException
     */
    public static void startTransaction() throws SQLException
    {
        Connection con = getConnection();
        if (con != null)
        {
            con.setAutoCommit(false);
        }
    }

    /**
     * 事务回滚
     * @throws SQLException
     */
    public static void rollback() throws SQLException
    {
        Connection con = getConnection();
        if (con != null)
        {
            con.rollback();
        }
    }

    /**
     * 提交并且 关闭资源及从ThreadLocall中释放
     * @throws SQLException
     */
    public static void commitAndRelease() throws SQLException
    {
        Connection con = getConnection();
        if (con != null)
        {
            con.commit(); // 事务提交
            con.close();// 关闭资源
            tl.remove();// 从线程绑定中移除
        }
    }

    /**
     * 关闭资源
     * @throws SQLException
     */
    public static void closeConnection() throws SQLException
    {
        Connection con = getConnection();
        if (con != null)
        {
            con.close();
        }
    }

    /**
     * 关闭连接并释放本地线程对象资源
     * @throws SQLException
     */
    public static void closeConnAndRelease() throws SQLException {
        Connection con = getConnection();
        if (con != null)
        {
            con.close();
            tl.remove();
        }
    }

    public static void closeStatement(Statement st) throws SQLException
    {
        if (st != null)
        {
            st.close();
        }
    }

    public static void closeResultSet(ResultSet rs) throws SQLException
    {
        if (rs != null)
        {
            rs.close();
        }
    }

}
