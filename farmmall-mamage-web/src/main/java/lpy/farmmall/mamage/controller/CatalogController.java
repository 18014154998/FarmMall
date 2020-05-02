package lpy.farmmall.mamage.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.PmsBaseCatalog1;
import lpy.farmmall.bean.PmsBaseCatalog2;
import lpy.farmmall.bean.PmsBaseCatalog3;
import lpy.farmmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/10 20:33
 * @verson 1.0
 * 后台分类模块，一级分类
 **/

@Controller
@CrossOrigin
public class CatalogController {

    @Reference
    CatalogService catalogService;

    //获取一级分类目录
    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        List<PmsBaseCatalog1> catalog1s=catalogService.getCatalog1();
        return  catalog1s;
    }

    //获取二级分类目录
    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id){
        List<PmsBaseCatalog2> catalog2s=catalogService.getCatalog2(catalog1Id);
        return  catalog2s;
    }
    //获取三级分类目录
    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id){
        List<PmsBaseCatalog3> catalog3s=catalogService.getCatalog3(catalog2Id);
        return  catalog3s;
    }

}
