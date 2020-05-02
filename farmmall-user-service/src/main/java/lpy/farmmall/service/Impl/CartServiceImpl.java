package lpy.farmmall.service.Impl;

import com.alibaba.dubbo.config.annotation.Service;
import lpy.farmmall.bean.OmsCartItem;
import lpy.farmmall.mapper.OmsCartItemMapper;
import lpy.farmmall.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/20 21:00
 * @verson 1.0
 **/
@Service
public class CartServiceImpl implements CartService {


    @Autowired
    OmsCartItemMapper omsCartItemMapper;

    //增加购物车信息
    @Override
    public int addshopCarInfo(OmsCartItem cartItem) {
        //先判断有没有，有了就在原有继承上添加，没有就新增
        OmsCartItem o1=new OmsCartItem();
        o1.setMemberId(cartItem.getMemberId());
        o1.setProductId(cartItem.getProductId());
        o1.setProductSkuId(cartItem.getProductSkuId());
        int count = omsCartItemMapper.selectCount(o1);
        System.out.println(count);
        if (count >=1){
            int i= omsCartItemMapper.updateCartadd(cartItem);
            System.out.println("更新");
            return i;
        }else {
            int i = omsCartItemMapper.insert(cartItem);
            System.out.println("insert");
            return i;
        }
    }
    //获取购物车信息
    @Override
    public List<OmsCartItem> getShoppinginfoListBymid(OmsCartItem cartItem) {
        List<OmsCartItem> omsCartItemList = omsCartItemMapper.select(cartItem);
        return omsCartItemList;
    }

    @Override
    public int reduicequantity(OmsCartItem cartItem) {
        int i = omsCartItemMapper.updatereduce(cartItem);
        return i;
    }

    @Override
    public int addquantity(OmsCartItem cartItem) {
        int i = omsCartItemMapper.updateAdd(cartItem);
        return i;
    }

    @Override
    public int deletespuCart(OmsCartItem cartItem) {
        int i=omsCartItemMapper.updateskucart(cartItem);
        return i;
    }
}
