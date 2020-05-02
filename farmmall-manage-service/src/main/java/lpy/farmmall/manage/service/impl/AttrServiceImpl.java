package lpy.farmmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import lpy.farmmall.bean.PmsBaseAttrInfo;
import lpy.farmmall.bean.PmsBaseAttrValue;
import lpy.farmmall.bean.PmsBaseSaleAttr;
import lpy.farmmall.manage.mapper.PmsBaseAttrInfoMapper;
import lpy.farmmall.manage.mapper.PmsBaseAttrValueMapper;
import lpy.farmmall.manage.mapper.PmsBaseSaleAttrMapper;
import lpy.farmmall.service.AttrService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/10 22:30
 * @verson 1.0
 **/
@Service
public class AttrServiceImpl implements AttrService {

    @Autowired
    PmsBaseAttrInfoMapper pmsBaseAttrInfoMapper;
    @Autowired
    PmsBaseAttrValueMapper pmsBaseAttrValueMapper;

    @Autowired
    PmsBaseSaleAttrMapper pmsBaseSaleAttrMapper;

    //根据类别查询平台属性
    @Override
    public List<PmsBaseAttrInfo> getAttrinfoList(String catalog3Id) {
        PmsBaseAttrInfo pa=new PmsBaseAttrInfo();
        pa.setCatalog3Id(catalog3Id);
        List<PmsBaseAttrInfo> pal = pmsBaseAttrInfoMapper.select(pa);
        for (PmsBaseAttrInfo baseAttrInfo : pal) {

            List<PmsBaseAttrValue> pmsBaseAttrValues = new ArrayList<>();
            PmsBaseAttrValue pmsBaseAttrValue = new PmsBaseAttrValue();
            pmsBaseAttrValue.setAttrId(baseAttrInfo.getId());
            pmsBaseAttrValues = pmsBaseAttrValueMapper.select(pmsBaseAttrValue);
            baseAttrInfo.setAttrValueList(pmsBaseAttrValues);
        }

        return pal;
    }
    //添加商品平台属性
    @Override
    public String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo) {
        //根据是否有id，来判断是添加操作还是修改操作
        if (StringUtils.isBlank(pmsBaseAttrInfo.getId())){//为空，添加
            //先保存属性
            pmsBaseAttrInfoMapper.insertSelective(pmsBaseAttrInfo);
            //在保存属性值
            List<PmsBaseAttrValue> attrValueslist=pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue attrValue : attrValueslist) {
                attrValue.setAttrId(pmsBaseAttrInfo.getId());
                pmsBaseAttrValueMapper.insertSelective(attrValue);
            }
            return "success";
        }else {//不为空，修改
            System.out.println(pmsBaseAttrInfo);
            //先修改属性
            Example example=new Example(PmsBaseAttrInfo.class);
            example.createCriteria().andEqualTo("id",pmsBaseAttrInfo.getId());
            pmsBaseAttrInfoMapper.updateByExample(pmsBaseAttrInfo,example);
            //在修改属性值
            PmsBaseAttrValue pms = new PmsBaseAttrValue();
            pms.setAttrId(pmsBaseAttrInfo.getId());
            pmsBaseAttrValueMapper.delete(pms);

            List<PmsBaseAttrValue> values= pmsBaseAttrInfo.getAttrValueList();
            for (PmsBaseAttrValue pmsBaseAttrValue : values) {
                System.out.println(pmsBaseAttrValue.getValueName());
                pmsBaseAttrValueMapper.insertSelective(pmsBaseAttrValue);

            }

            return "success";
        }


    }
    //根据属性获取具体属性值
    @Override
    public List<PmsBaseAttrValue> getAttrValueList(String attrId) {
        PmsBaseAttrValue pv=new PmsBaseAttrValue();
        pv.setAttrId(attrId);
        List<PmsBaseAttrValue> p = pmsBaseAttrValueMapper.select(pv);
        return p;
    }
    //查询销售属性
    @Override
    public List<PmsBaseSaleAttr> baseSaleAttrList() {
        return pmsBaseSaleAttrMapper.selectAll();
    }


}
