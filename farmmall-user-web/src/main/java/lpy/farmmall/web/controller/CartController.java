package lpy.farmmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import lpy.farmmall.bean.OmsCartItem;
import lpy.farmmall.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/20 20:59
 * @verson 1.0
 **/
@Controller
@CrossOrigin
public class CartController {
    @Reference
    CartService CartService;

    //（删除也包括了，就是将原本的状态由0改为1即可）
    @RequestMapping("/api/addShoppingcar")
    @ResponseBody
    public String addShoppingcar(@RequestBody OmsCartItem cartItem){
        System.out.println(cartItem);
        cartItem.setDeleteStatus("0");
        int i =CartService.addshopCarInfo(cartItem);
        if (i>0){return "ok";}else {return "error";}
    }
    //获取购物车信息
    @RequestMapping("/api/getShoppinginfoList")
    @ResponseBody
    public List<OmsCartItem> getShoppinginfoListBymid(@RequestBody OmsCartItem cartItem){
        System.out.println(cartItem.getMemberId()+" x  "+cartItem.getDeleteStatus());
        cartItem.setDeleteStatus("0");
        List<OmsCartItem> cartlist=CartService.getShoppinginfoListBymid(cartItem);
        return cartlist;
    }
    //购物车信息减少1
    @RequestMapping("/api/reducequantity")
    @ResponseBody
    public String reducequantity(@RequestBody OmsCartItem cartItem){
        int i=CartService.reduicequantity(cartItem);
        System.out.println(i);
        return "ok";
    }
    //购物车信息加上1
    @RequestMapping("/api/addquantity")
    @ResponseBody
    public String addquantity(@RequestBody OmsCartItem cartItem){
        int i=CartService.addquantity(cartItem);
        System.out.println(i);
        return "ok";
    }
    //删除购物车信息加上1
    @RequestMapping("/api/deletecart")
    @ResponseBody
    public String deletecart(@RequestBody OmsCartItem cartItem){
        int i=CartService.deletespuCart(cartItem);
        System.out.println(i);
        return "ok";
    }

}
