package lpy.farmmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.PmsBaseAttrInfo;
import lpy.farmmall.bean.PmsProductInfo;
import lpy.farmmall.bean.PmsSkuInfo;
import lpy.farmmall.service.AttrService;
import lpy.farmmall.service.SkuService;
import lpy.farmmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/18 10:49
 * @verson 1.0
 **/
@Controller
@CrossOrigin
public class ProductController {

    @Reference
    AttrService attrService;

    @Reference
    SpuService spuService;

    @Reference
    SkuService skuService;

    @RequestMapping("/api/getAllProduct")
    @ResponseBody
    public  List<PmsProductInfo> getProductName(){
        List<PmsProductInfo> pmsProductInfos = spuService.getAllpmsinfo();
        return pmsProductInfos;
    }
    //根据商品的3级分类，获取具体商品属性
    @RequestMapping("/api/getAttrinfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrinfoList(@RequestBody PmsProductInfo p){
        System.out.println("ca3id"+p.getCatalog3Id());
        List<PmsBaseAttrInfo> pmsBaseAttrInfos=attrService.getAttrinfoList(p.getCatalog3Id());
        return pmsBaseAttrInfos;
    }

    //根据商品的3级分类，获取具体商品属性
    @RequestMapping("/api/getProductinfoList")
    @ResponseBody
    public List<PmsProductInfo> spuList(@RequestBody PmsProductInfo p){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(p.getCatalog3Id());
        return pmsProductInfos;
    }
    //商品搜索，显示下拉列表可供选择的商品
    @RequestMapping("/api/getProductName")
    @ResponseBody
    public List<PmsProductInfo> getProName(@RequestBody PmsProductInfo p){
        System.out.println(p.getProductName());
        List<PmsProductInfo> productInfos=spuService.getInfoByName(p);
        return productInfos;
    }
    //根据spuid获取商品sku具体属性
    @RequestMapping("/api/getSkuInfoBySpuId")
    @ResponseBody
    public List<PmsSkuInfo> getSkuInfoBySpuId(@RequestBody PmsSkuInfo skuInfo){
        System.out.println(skuInfo.getProductId());
        List<PmsSkuInfo> skuInfoslist=skuService.getSkuInfoBySpuId(skuInfo);
        return skuInfoslist;
    }
    //根据spuid获取商品sku具体属性
    @RequestMapping("/api/getSkuInfoBySkuId")
    @ResponseBody
    public PmsSkuInfo getSkuInfoBySkuId(@RequestBody PmsSkuInfo skuInfo){
        System.out.println("skuid:"+skuInfo.getId());
        PmsSkuInfo skuInfo1=skuService.getSkuInfoBySkuId(skuInfo);
        return skuInfo1;
    }


}
