package lpy.farmmall.web.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import lpy.farmmall.bean.AlipayBeanTest;
import lpy.farmmall.bean.OmsOrder;
import lpy.farmmall.bean.OmsOrderItem;
import lpy.farmmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author:刘平远
 * @Date：2020/4/22 20:49
 * @verson 1.0
 **/
@Controller
@CrossOrigin
public class PayController {

    @Autowired
    AlipayClient alipayClient;

    @Reference
    OrderService orderService;

    AlipayBeanTest bean1=new AlipayBeanTest();

    //支付宝测试
    @RequestMapping("/api/testAlipay")
    @ResponseBody
    public String alipaytest(@RequestBody AlipayBeanTest beanTest){
        bean1 = beanTest;
        String form=null;
        System.out.println("ok"+ beanTest.toString());
        //获取支付宝请求的客户端（不是连接），而是封装的http请求
        //创建API对应的request
        AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest();

        //跳转页面之前需要回调的接口验证//内网穿透
        alipayRequest.setNotifyUrl("http://xppcaomei.free.idcfengye.com/api/returnAlipay");
        //付款成功后跳转到的页面
        alipayRequest.setReturnUrl("http://127.0.0.1:8088/index");
        Map<String,Object> map=new HashMap<>();
        map.put("out_trade_no",beanTest.getOmsOrder().getOrderSn());
        map.put("product_code","FAST_INSTANT_TRADE_PAY");
        map.put("total_amount",beanTest.getOmsOrder().getTotalAmount());
        map.put("subject",beanTest.getOmsOrderItem().get(0).getProductName());
        String parm=JSON.toJSONString(map);
        alipayRequest.setBizContent(parm);
        try {
            form = alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
            System.out.println(form);
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        //生成保存用户的支付信息，
        //todo
        return form;
    }

    //生成订单表
    /*@RequestMapping("/api/submitOrder")
    @ResponseBody*/
    public String testOrder(AlipayBeanTest beanTest){
       // beanTest=bean1;
        System.out.println(beanTest);
        //AlipayBeanTest{orderno='2020042232206', amountsale='22.06', producttitle='22点06',
        //订单表信息
        /* omsOrder=OmsOrder{id='', memberId='12', orderSn='20204241416201284',
         createTime=null, memberUsername='lpy123', totalAmount=80, payAmount=80,
         receiverName='刘平远', receiverPhone='18033441849', receiverProvince='广东省',
         receiverCity='深圳市', receiverRegion='南山区', receiverDetailAddress='科兴科学园'},*/
        //订单详情表信息
        /* omsOrderItem=[OmsOrderItem {id='', orderId='', orderSn='20204241416201284',
        // productId='84', productName='4斤红颜草莓', productSn='null', productPrice='80',
        // productQuantity=1, productSkuId='84', productCategoryId='61', realAmount=''}]}*/
        //跟新数据-->将订单表和订单详情表插入数据库中
        //先插入订单表
        //时间插入
        Date currentdata=new Date();
        beanTest.getOmsOrder().setCreateTime(currentdata);
        int orderPK = orderService.addOrderInfo(beanTest.getOmsOrder());
        //在插入订单详情表
        int orderDetail=orderService.addOrderDetailInfo(beanTest.getOmsOrderItem().get(0));
        if (orderPK>=1&&orderDetail>=1){
        return "order is ok";
        }else {
            return "order is error";
        }
    }

    //支付宝回调接口测试
    @RequestMapping("/api/returnAlipay")
    @ResponseBody
    public String returnalipay(){
        System.out.println("进入了支付回调");
        //根据签名验证数据源是否真确(默认成功了)，正确了然后执行订单和详情的操作。
        String str = testOrder(bean1);
        if (str.equals("order is ok")){
            return "success";
        }else {
            return "failure";
        }
    }

}
