package com.jit.zky.service;

import com.jit.zky.dao.PcodeDao;
import com.jit.zky.dao.ProductDao;
import com.jit.zky.entity.Category;
import com.jit.zky.entity.FloorVo;
import com.jit.zky.entity.Pcode;
import com.jit.zky.entity.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final PcodeService dao = new PcodeService();
    private final ProductDao pdao = new ProductDao();
    /**
     * 查询各楼层热门商品信息
     * @param start
     * @param pagesize
     * @return
     */
    public List<FloorVo> findeFloorsHotProducts(int start, int pagesize)
    {
        List<Pcode> pcodeList = dao.findPcodeListByCodeType("4");
        List<FloorVo> floorVos = new ArrayList<FloorVo>();
        for (Pcode pcode : pcodeList)
        {
            List<Product> products = pdao.findHotProductListByPage(pcode.getParam2(), start, pagesize);
            FloorVo vo = new FloorVo();
            vo.setFloorNo(pcode.getParam7());
            vo.setHotProducts(products);
            floorVos.add(vo);
        }
        return floorVos;
    }

    public List<Category> navigationBar() {
        List<Category> categoryList = null;
        try {
            categoryList = pdao.findAllCategory();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return categoryList;
    }

}
