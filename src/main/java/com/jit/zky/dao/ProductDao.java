package com.jit.zky.dao;

import com.jit.zky.entity.Product;
import com.jit.zky.utils.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDao {
    private QueryRunner runner = new QueryRunner(DataSourceUtil.getDataSource());

    /**
     * 根据商品类别查询热门商品信息
     *
     * @return
     */
    public List<Product> findHotProductListByPage(String cid, int start, int pagesize) {
        List<Product> cList = null;
        String sql = " select * from product a where a.is_hot = 1 and a.cid = ? order by pdate desc limit ?,?";
        try {
            cList = runner.query(sql, new BeanListHandler<Product>(Product.class), cid, start, pagesize);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cList;
    }

}
