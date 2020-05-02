package lpy.farmmall.mamage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.PmsBaseAttrInfo;
import lpy.farmmall.bean.PmsBaseAttrValue;
import lpy.farmmall.bean.PmsBaseSaleAttr;
import lpy.farmmall.service.AttrService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/10 22:20
 * @verson 1.0
 * 商品属性的crud
 **/

@Controller
@CrossOrigin
public class AttrController {

    @Reference
    AttrService attrService;

    //获取所选类别列表信息
    @RequestMapping("attrInfoList")
    @ResponseBody
    public List<PmsBaseAttrInfo> getAttrinfoList(String catalog3Id){
        List<PmsBaseAttrInfo> pmsBaseAttrInfos=attrService.getAttrinfoList(catalog3Id);
        return pmsBaseAttrInfos;
    }

    //添加商品新的属性与属性值
    @RequestMapping("saveAttrInfo")
    @ResponseBody
    public String saveAttrInfo(@RequestBody PmsBaseAttrInfo pmsBaseAttrInfo){
        String result=attrService.saveAttrInfo(pmsBaseAttrInfo);
        return "sucess";
    }
    //根据属性获取具体属性值
    @RequestMapping("getAttrValueList")
    @ResponseBody
    public List<PmsBaseAttrValue> getAttrValueList(String attrId){
        List<PmsBaseAttrValue> values=attrService.getAttrValueList(attrId);
        return values;
    }
    //销售属性查询
    @RequestMapping("baseSaleAttrList")
    @ResponseBody
    public List<PmsBaseSaleAttr> baseSaleAttrList(){

        List<PmsBaseSaleAttr> pmsBaseSaleAttrs = attrService.baseSaleAttrList();
        return pmsBaseSaleAttrs;
    }




}
