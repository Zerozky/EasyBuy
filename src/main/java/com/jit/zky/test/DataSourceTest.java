package com.jit.zky.test;

import java.sql.SQLException;
import java.util.Map;

import com.jit.zky.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;

public class DataSourceTest
{
    private static QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    public static void main(String[] args)
    {
        Map<String, Object> map = findCategoryById(1);
        System.out.println("map-> " + map);
    }

    private static Map<String, Object> findCategoryById(int id)
    {
        String sql = "select * from category a where a.cid = ?";
        Map<String, Object> map = null;
        try
        {
            map = queryRunner.query(sql, new MapHandler(), id);
        }
        catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return map;

    }
}
