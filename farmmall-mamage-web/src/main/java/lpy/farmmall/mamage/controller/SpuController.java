package lpy.farmmall.mamage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.PmsProductImage;
import lpy.farmmall.bean.PmsProductInfo;
import lpy.farmmall.bean.PmsProductSaleAttr;
import lpy.farmmall.mamage.util.PmsUploadUtil;
import lpy.farmmall.service.SpuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/11 10:19
 * @verson 1.0
 **/
@Controller
@CrossOrigin
public class SpuController {

    @Reference
    SpuService spuService;

    //根据商品的3级分类，获取具体商品属性
    @RequestMapping("spuList")
    @ResponseBody
    public List<PmsProductInfo> spuList(String catalog3Id){
        List<PmsProductInfo> pmsProductInfos = spuService.spuList(catalog3Id);
        return pmsProductInfos;
    }
    //图片文件上传
    @RequestMapping("fileUpload")
    @ResponseBody
    public String fileUpload(@RequestParam("file") MultipartFile multipartFile){
        // 将图片或者音视频上传到分布式的文件存储系统
        // 将图片的存储路径返回给页面
        //String imgUrl = "https://m.360buyimg.com/babel/jfs/t5137/20/1794970752/352145/d56e4e94/591417dcN4fe5ef33.jpg";
        /*String imgUrl=PmsUploadUtil.uploadImage(multipartFile);
        System.out.println(imgUrl);*/
        return "imageurl";
    }

    //添加商品spu
    @RequestMapping("saveSpuInfo")
    @ResponseBody
    public String saveSpuInfo(@RequestBody PmsProductInfo pmsProductInfo){
        System.out.println(pmsProductInfo);
        spuService.saveSpuInfo(pmsProductInfo);
        return "success";
    }

    @RequestMapping("spuImageList")
    @ResponseBody
    public List<PmsProductImage> spuImageList(String spuId){

        List<PmsProductImage> pmsProductImages = spuService.spuImageList(spuId);
        return pmsProductImages;
    }

    @RequestMapping("spuSaleAttrList")
    @ResponseBody
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId){

        List<PmsProductSaleAttr> pmsProductSaleAttrs = spuService.spuSaleAttrList(spuId);
        return pmsProductSaleAttrs;
    }


}
