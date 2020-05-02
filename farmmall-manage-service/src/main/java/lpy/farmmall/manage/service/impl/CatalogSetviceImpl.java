package lpy.farmmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import lpy.farmmall.bean.PmsBaseCatalog1;
import lpy.farmmall.bean.PmsBaseCatalog2;
import lpy.farmmall.bean.PmsBaseCatalog3;
import lpy.farmmall.manage.mapper.PmsBaseCatalog1Mapper;
import lpy.farmmall.manage.mapper.PmsBaseCatalog2Mapper;
import lpy.farmmall.manage.mapper.PmsBaseCatalog3Mapper;
import lpy.farmmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/10 21:05
 * @verson 1.0
 **/
@Service
public class CatalogSetviceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;
    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;
    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    //获取一级目录
    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    //获取二级目录
    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {
        PmsBaseCatalog2 pt2=new PmsBaseCatalog2();
        pt2.setCatalog1Id(catalog1Id);
        List<PmsBaseCatalog2> pmsBaseCatalog2s = pmsBaseCatalog2Mapper.select(pt2);
        return pmsBaseCatalog2s;
    }

    //获取三级目录
    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {
        PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> baseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return baseCatalog3s;
    }
}
