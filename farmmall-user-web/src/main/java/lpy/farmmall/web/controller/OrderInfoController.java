package lpy.farmmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.OrderInfo;
import lpy.farmmall.bean.UmsMember;
import lpy.farmmall.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/24 23:20
 * @verson 1.0
 **/
@Controller
@CrossOrigin
public class OrderInfoController {

    @Reference
    OrderService orderService;

    //根据用户id，来获取订单信息，根据订单的创建时间降序排序
    @RequestMapping("/api/getOrderInfo")
    @ResponseBody
    public List<OrderInfo> getOrderInfoByuid(@RequestBody UmsMember umsMember){

        List<OrderInfo> orderInfoList=orderService.getOrderInfoByuid(umsMember);

        return orderInfoList;
    }

}
