package lpy.farmmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import lpy.farmmall.bean.PmsSkuAttrValue;
import lpy.farmmall.bean.PmsSkuImage;
import lpy.farmmall.bean.PmsSkuInfo;
import lpy.farmmall.bean.PmsSkuSaleAttrValue;
import lpy.farmmall.manage.mapper.PmsSkuAttrValueMapper;
import lpy.farmmall.manage.mapper.PmsSkuImageMapper;
import lpy.farmmall.manage.mapper.PmsSkuInfoMapper;
import lpy.farmmall.manage.mapper.PmsSkuSaleAttrValueMapper;
import lpy.farmmall.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/13 23:14
 * @verson 1.0
 **/
@Service
public class SkuServiceImpl implements SkuService {

    @Autowired
    PmsSkuInfoMapper pmsSkuInfoMapper;

    @Autowired
    PmsSkuAttrValueMapper pmsSkuAttrValueMapper;

    @Autowired
    PmsSkuSaleAttrValueMapper pmsSkuSaleAttrValueMapper;

    @Autowired
    PmsSkuImageMapper pmsSkuImageMapper;


    //保存sku
    @Override
    public void saveSkuInfo(PmsSkuInfo pmsSkuInfo) {
        // 插入skuInfo
        int i = pmsSkuInfoMapper.insertSelective(pmsSkuInfo);
        String skuId = pmsSkuInfo.getId();

        // 插入平台属性关联
        List<PmsSkuAttrValue> skuAttrValueList = pmsSkuInfo.getSkuAttrValueList();
        for (PmsSkuAttrValue pmsSkuAttrValue : skuAttrValueList) {
            pmsSkuAttrValue.setSkuId(skuId);
            pmsSkuAttrValueMapper.insertSelective(pmsSkuAttrValue);
        }

        // 插入销售属性关联
        List<PmsSkuSaleAttrValue> skuSaleAttrValueList = pmsSkuInfo.getSkuSaleAttrValueList();
        for (PmsSkuSaleAttrValue pmsSkuSaleAttrValue : skuSaleAttrValueList) {
            pmsSkuSaleAttrValue.setSkuId(skuId);
            pmsSkuSaleAttrValueMapper.insertSelective(pmsSkuSaleAttrValue);
        }

        // 插入图片信息
        List<PmsSkuImage> skuImageList = pmsSkuInfo.getSkuImageList();
        for (PmsSkuImage pmsSkuImage : skuImageList) {
            pmsSkuImage.setSkuId(skuId);
            pmsSkuImageMapper.insertSelective(pmsSkuImage);
        }

    }
    //根据spuid查询商品sku具体属性
    @Override
    public List<PmsSkuInfo> getSkuInfoBySpuId(PmsSkuInfo skuInfo) {
        List<PmsSkuInfo> skuInfos = pmsSkuInfoMapper.select(skuInfo);
        /*List<PmsSkuInfo> skuInfosONE = new ArrayList<>();
        skuInfosONE.add(skuInfos.get(0));*/
        return skuInfos;
    }
    //根据spuid获取商品sku具体属性
    @Override
    public PmsSkuInfo getSkuInfoBySkuId(PmsSkuInfo skuInfo) {
        PmsSkuInfo pmsSkuInfo = pmsSkuInfoMapper.selectByPrimaryKey(skuInfo.getId());
        return pmsSkuInfo;
    }
}
