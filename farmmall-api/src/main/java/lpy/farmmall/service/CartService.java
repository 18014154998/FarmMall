package lpy.farmmall.service;

import lpy.farmmall.bean.OmsCartItem;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/20 20:58
 * @verson 1.0
 **/
public interface CartService {
    //增加购物车信息
    int addshopCarInfo(OmsCartItem cartItem);
    //获取购物车信息
    List<OmsCartItem> getShoppinginfoListBymid(OmsCartItem cartItem);

    int reduicequantity(OmsCartItem cartItem);

    int addquantity(OmsCartItem cartItem);

    int deletespuCart(OmsCartItem cartItem);
}
