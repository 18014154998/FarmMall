package lpy.farmmall.service;

import lpy.farmmall.bean.PmsProductImage;
import lpy.farmmall.bean.PmsProductInfo;
import lpy.farmmall.bean.PmsProductSaleAttr;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/11 10:25
 * @verson 1.0
 **/
public interface SpuService {

    //根据商品的3级分类，获取具体商品属性
    List<PmsProductInfo> spuList(String catalog3Id);

    //添加商品spu
    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);

    List<PmsProductInfo> getAllpmsinfo();
    //商品搜索，显示下拉列表可供选择的商品
    List<PmsProductInfo> getInfoByName(PmsProductInfo productName);
}
