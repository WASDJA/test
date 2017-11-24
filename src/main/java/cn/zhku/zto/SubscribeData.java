package cn.zhku.zto;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

/**
 * @ClassName: SubscribeData
 * @Description: 订阅类实体
 */
public class SubscribeData {

    /**
     * 序列化
     */
    @SuppressWarnings("unused")
    private static final long serialVersionUID = 1L;

    private String id;

    private String billCode;

    private String pushCategory;

    private String pushTarget;

    private short pushTime;

    private short subscriptionCategory;

    private String createBy;

    private String isThird;

    private String extraPram;

    private String createDate;

    public SubscribeData() {
        super();
    }

    public SubscribeData(String billCode, String isThird, String createDate) {
        super();
        this.billCode = billCode;
        this.isThird = isThird;
        this.createDate = createDate;
    }

    public String getIsThird() {
        return isThird;
    }

    public void setIsThird(String isThird) {
        this.isThird = isThird;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getPushCategory() {
        return pushCategory;
    }

    public void setPushCategory(String pushCategory) {
        this.pushCategory = pushCategory;
    }

    public String getPushTarget() {
        return pushTarget;
    }

    public void setPushTarget(String pushTarget) {
        this.pushTarget = pushTarget;
    }

    public short getPushTime() {
        return pushTime;
    }

    public void setPushTime(short pushTime) {
        this.pushTime = pushTime;
    }

    public short getSubscriptionCategory() {
        return subscriptionCategory;
    }

    public void setSubscriptionCategory(short subscriptionCategory) {
        this.subscriptionCategory = subscriptionCategory;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getExtraPram() {
        return extraPram;
    }

    public void setExtraPram(String extraPram) {
        this.extraPram = extraPram;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "SubscribeData [id=" + id + ", billCode=" + billCode
                + ", pushCategory=" + pushCategory + ", pushTarget="
                + pushTarget + ", pushTime=" + pushTime
                + ", subscriptionCategory=" + subscriptionCategory
                + ", createBy=" + createBy + ", extraPram=" + extraPram
                + ", createDate=" + createDate + "]";
    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        String s = "{\"billCode\": \"532246117447\", \"contacts\":\"签收:同事\", \"contactsTel\": \"\", \"desc\": \"在2016-09-07 16:34:16签收,详情可登录www.zto.com查看,感谢使用中通快递\", \"scanCity\": \"永州市\", \"scanDate\": \"2016-09-07 16:34:16\", \"scanSite\": \"永州\", \"scanType\": \"SIGN\", \"remark1\": \"\", \"remark2\": \"\", \"remark3\": \"\", \"remark4\": \"\", \"remark5\": \"\", \"remark6\": \"\"}";
        s = URLDecoder.decode(s, "utf-8");
        System.out.println(s);

        String china = "%31%32%36%2E%61%6D/hEeGv4";
        china = URLDecoder.decode(china, "utf-8");
        System.out.println(china);
    }
}
