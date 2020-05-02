package lpy.farmmall.mapper;

import lpy.farmmall.bean.OmsCartItem;
import tk.mybatis.mapper.common.Mapper;

/**
 * @Author:刘平远
 * @Date：2020/4/20 21:00
 * @verson 1.0
 **/
public interface OmsCartItemMapper extends Mapper<OmsCartItem> {

    //添加已经存在的购物成信息
    int updateCartadd(OmsCartItem cartItem);

    int updatereduce(OmsCartItem cartItem);

    int updateAdd(OmsCartItem cartItem);

    int updateskucart(OmsCartItem cartItem);
}
