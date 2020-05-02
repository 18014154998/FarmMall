package lpy.farmmall.bean;

import java.io.Serializable;
import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/22 21:07
 * @verson 1.0
 **/
public class AlipayBeanTest implements Serializable {

    private String  orderno;
    private String amountsale;
    private String producttitle;

    private OmsOrder omsOrder;
    private List<OmsOrderItem> omsOrderItem;

    @Override
    public String toString() {
        return "AlipayBeanTest{" +
                "orderno='" + orderno + '\'' +
                ", amountsale='" + amountsale + '\'' +
                ", producttitle='" + producttitle + '\'' +
                ", omsOrder=" + omsOrder +
                ", omsOrderItem=" + omsOrderItem +
                '}';
    }

    public OmsOrder getOmsOrder() {
        return omsOrder;
    }

    public void setOmsOrder(OmsOrder omsOrder) {
        this.omsOrder = omsOrder;
    }

    public List<OmsOrderItem> getOmsOrderItem() {
        return omsOrderItem;
    }

    public void setOmsOrderItem(List<OmsOrderItem> omsOrderItem) {
        this.omsOrderItem = omsOrderItem;
    }

    public String getOrderno() {
        return orderno;
    }

    public void setOrderno(String orderno) {
        this.orderno = orderno;
    }

    public String getAmountsale() {
        return amountsale;
    }

    public void setAmountsale(String amountsale) {
        this.amountsale = amountsale;
    }

    public String getProducttitle() {
        return producttitle;
    }

    public void setProducttitle(String producttitle) {
        this.producttitle = producttitle;
    }
}
