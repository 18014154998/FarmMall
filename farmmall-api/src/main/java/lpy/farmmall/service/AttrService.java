package lpy.farmmall.service;

import lpy.farmmall.bean.PmsBaseAttrInfo;
import lpy.farmmall.bean.PmsBaseAttrValue;
import lpy.farmmall.bean.PmsBaseSaleAttr;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/10 22:29
 * @verson 1.0
 **/
public interface AttrService  {
    //获取平台类别属性
    List<PmsBaseAttrInfo> getAttrinfoList(String catalog3Id);
    //添加商品平台属性
    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);
    //根据属性获取具体属性值
    List<PmsBaseAttrValue> getAttrValueList(String attrId);
    //查询销售属性
    List<PmsBaseSaleAttr> baseSaleAttrList();
}
