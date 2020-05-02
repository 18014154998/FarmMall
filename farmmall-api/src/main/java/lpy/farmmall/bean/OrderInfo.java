package lpy.farmmall.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author:刘平远
 * @Date：2020/4/24 23:19
 * @verson 1.0
 **/
public class OrderInfo implements Serializable {

    private String id;
    private String    memberId;
    //重点
    private String  orderSn;
    private Date createTime;
    private String       memberUsername;
    private BigDecimal totalAmount;
    private BigDecimal       payAmount;
    private String receiverName;
    private String         receiverPhone;
    private String receiverPostCode;
    private String         receiverProvince;
    private String receiverCity;
    private String        receiverRegion;
    private String receiverDetailAddress;
    private String         note;
    private int         deleteStatus;
    private int useIntegration;
    private Date        paymentTime;
    private Date         receiveTime;
    private Date commentTime;
    private Date        modifyTime;
    private OmsOrderItem omsOrderItem;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "id='" + id + '\'' +
                ", memberId='" + memberId + '\'' +
                ", orderSn='" + orderSn + '\'' +
                ", createTime=" + createTime +
                ", memberUsername='" + memberUsername + '\'' +
                ", totalAmount=" + totalAmount +
                ", payAmount=" + payAmount +
                ", receiverName='" + receiverName + '\'' +
                ", receiverPhone='" + receiverPhone + '\'' +
                ", receiverPostCode='" + receiverPostCode + '\'' +
                ", receiverProvince='" + receiverProvince + '\'' +
                ", receiverCity='" + receiverCity + '\'' +
                ", receiverRegion='" + receiverRegion + '\'' +
                ", receiverDetailAddress='" + receiverDetailAddress + '\'' +
                ", note='" + note + '\'' +
                ", deleteStatus=" + deleteStatus +
                ", useIntegration=" + useIntegration +
                ", paymentTime=" + paymentTime +
                ", receiveTime=" + receiveTime +
                ", commentTime=" + commentTime +
                ", modifyTime=" + modifyTime +
                ", omsOrderItem=" + omsOrderItem +
                '}';
    }

    public OmsOrderItem getOmsOrderItem() {
        return omsOrderItem;
    }

    public void setOmsOrderItem(OmsOrderItem omsOrderItem) {
        this.omsOrderItem = omsOrderItem;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getPayAmount() {
        return payAmount;
    }

    public void setPayAmount(BigDecimal payAmount) {
        this.payAmount = payAmount;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostCode() {
        return receiverPostCode;
    }

    public void setReceiverPostCode(String receiverPostCode) {
        this.receiverPostCode = receiverPostCode;
    }

    public String getReceiverProvince() {
        return receiverProvince;
    }

    public void setReceiverProvince(String receiverProvince) {
        this.receiverProvince = receiverProvince;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverRegion() {
        return receiverRegion;
    }

    public void setReceiverRegion(String receiverRegion) {
        this.receiverRegion = receiverRegion;
    }

    public String getReceiverDetailAddress() {
        return receiverDetailAddress;
    }

    public void setReceiverDetailAddress(String receiverDetailAddress) {
        this.receiverDetailAddress = receiverDetailAddress;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(int deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public int getUseIntegration() {
        return useIntegration;
    }

    public void setUseIntegration(int useIntegration) {
        this.useIntegration = useIntegration;
    }

    public Date getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(Date paymentTime) {
        this.paymentTime = paymentTime;
    }

    public Date getReceiveTime() {
        return receiveTime;
    }

    public void setReceiveTime(Date receiveTime) {
        this.receiveTime = receiveTime;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

}
