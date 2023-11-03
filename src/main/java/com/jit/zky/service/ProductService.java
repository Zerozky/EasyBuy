package com.jit.zky.service;

import com.jit.zky.dao.PcodeDao;
import com.jit.zky.dao.ProductDao;
import com.jit.zky.entity.Pcode;
import com.jit.zky.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final PcodeDao dao = new PcodeDao();
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
    /**
     * 返回楼层对应商品列表信息
     * @ClassName FloorVo
     * @author 86159清风明月
     * @date 2022年11月14日 上午4:31:57
     */
    public class FloorVo
    {
        private String floorNo;
        private List<Product> hotProducts;

        public String getFloorNo() {
            return floorNo;
        }

        public void setFloorNo(String floorNo) {
            this.floorNo = floorNo;
        }

        public List<Product> getHotProducts() {
            return hotProducts;
        }

        public void setHotProducts(List<Product> hotProducts) {
            this.hotProducts = hotProducts;
        }
    }

}
