package lpy.farmmall.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import lpy.farmmall.bean.OmsOrder;
import lpy.farmmall.bean.OmsOrderItem;
import lpy.farmmall.bean.OrderInfo;
import lpy.farmmall.bean.UmsMember;
import lpy.farmmall.mapper.OmsOrderItemMapper;
import lpy.farmmall.mapper.OmsOrderMapper;
import lpy.farmmall.mapper.OrderInfoMapper;
import lpy.farmmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/24 16:53
 * @verson 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OmsOrderMapper omsOrderMapper;

    @Autowired
    OmsOrderItemMapper omsOrderItemMapper;

    @Autowired
    OrderInfoMapper orderInfoMapper;

    @Override
    public int addOrderInfo(OmsOrder omsOrder) {
        System.out.println("将被插入的订单表信息"+omsOrder);
        int i = omsOrderMapper.insert(omsOrder);
        return i;
    }

    @Override
    public int addOrderDetailInfo(OmsOrderItem omsOrderItem) {
        System.out.println("将被插入的订单详情表信息"+omsOrderItem);
        int i = omsOrderItemMapper.insert(omsOrderItem);
        return i;
    }

    @Override
    public List<OrderInfo> getOrderInfoByuid(UmsMember umsMember) {
        List<OrderInfo> orderInfoList= orderInfoMapper.selectOrderInfoByuid(umsMember);
        System.out.println(orderInfoList);
        return orderInfoList;
    }
}
