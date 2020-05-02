package lpy.farmmall.mapper;

import lpy.farmmall.bean.OrderInfo;
import lpy.farmmall.bean.UmsMember;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/24 23:27
 * @verson 1.0
 **/
public interface OrderInfoMapper  {

    List<OrderInfo> selectOrderInfoByuid(UmsMember umsMember);
}
