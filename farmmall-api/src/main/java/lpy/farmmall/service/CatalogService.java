package lpy.farmmall.service;

import lpy.farmmall.bean.PmsBaseCatalog1;
import lpy.farmmall.bean.PmsBaseCatalog2;
import lpy.farmmall.bean.PmsBaseCatalog3;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/10 21:02
 * @verson 1.0
 **/
public interface CatalogService {

    //获取一级目录
    List<PmsBaseCatalog1> getCatalog1();

    //获取二级目录
    List<PmsBaseCatalog2> getCatalog2(String catalog1Id);
    //获取三级目录
    List<PmsBaseCatalog3> getCatalog3(String catalog2Id);
}
