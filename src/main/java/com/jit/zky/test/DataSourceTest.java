package com.jit.zky.test;

import java.sql.SQLException;
import java.util.Map;

import com.jit.zky.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.MapHandler;


/**
 * 测试数据源
 * @ClassName DataSourceTest
 * @author 86159
 * @date 2022年7月23日 下午9:26:25
 */
public class DataSourceTest
{
    private static QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());

    public static void main(String[] args)
    {
        Map<String, Object> map = findCategoryById(1);
        System.out.println("map-> " + map);
    }

    /**
     * 根据id查询分类信息
     * @param id
     */
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
