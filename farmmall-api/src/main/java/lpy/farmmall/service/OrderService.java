package lpy.farmmall.service;

import lpy.farmmall.bean.OmsOrder;
import lpy.farmmall.bean.OmsOrderItem;
import lpy.farmmall.bean.OrderInfo;
import lpy.farmmall.bean.UmsMember;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/24 16:53
 * @verson 1.0
 **/
public interface OrderService  {


    int addOrderInfo(OmsOrder omsOrder);

    int addOrderDetailInfo(OmsOrderItem omsOrderItem);

    List<OrderInfo> getOrderInfoByuid(UmsMember umsMember);
}
