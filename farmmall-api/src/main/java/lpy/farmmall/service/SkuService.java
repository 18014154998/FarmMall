package lpy.farmmall.service;

import lpy.farmmall.bean.PmsSkuInfo;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/13 22:54
 * @verson 1.0
 **/
public interface SkuService {
    //保存sku
    void saveSkuInfo(PmsSkuInfo pmsSkuInfo);
    //根据spuid获取商品sku具体属性
    List<PmsSkuInfo> getSkuInfoBySpuId(PmsSkuInfo skuInfo);
    //根据spuid获取商品sku具体属性
    PmsSkuInfo getSkuInfoBySkuId(PmsSkuInfo skuInfo);
}
