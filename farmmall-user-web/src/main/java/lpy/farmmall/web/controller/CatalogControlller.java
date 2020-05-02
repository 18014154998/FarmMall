package lpy.farmmall.web.controller;

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
 * @Date：2020/4/17 22:31
 * @verson 1.0
 **/
@Controller
@CrossOrigin
public class CatalogControlller {

    @Reference
    CatalogService catalogService;

    //获取一级分类目录
    @RequestMapping("/api/getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1(){
        System.out.println("进入了获取一级目录");
        List<PmsBaseCatalog1> catalog1s=catalogService.getCatalog1();
        return  catalog1s;
    }

    //获取二级分类目录
    @RequestMapping("/api/getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(@RequestBody PmsBaseCatalog2 catalog1Id){
        System.out.println("进入了获取二级目录"+catalog1Id.getCatalog1Id());
        List<PmsBaseCatalog2> catalog2s=catalogService.getCatalog2(catalog1Id.getCatalog1Id());
        return  catalog2s;
    }
    //获取三级分类目录
    @RequestMapping("/api/getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(@RequestBody PmsBaseCatalog3 catalog2Id){
        System.out.println("进入了获取三级目录"+catalog2Id.getCatalog2Id());
        List<PmsBaseCatalog3> catalog3s=catalogService.getCatalog3(catalog2Id.getCatalog2Id());
        return  catalog3s;
    }


}
