package cn.zhku.zto;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName: CallBack
 * @Description: 回调接口
 * @author: heyang
 * @date: 2017年6月13日 下午12:47:27
 */
@Controller
public class CallBack {
    private final static Logger logger = LoggerFactory.getLogger(CallBack.class);

    /**
     * @param data        消息内容
     * @param msg_type    消息类型
     * @param company_id  合作商ID（为调用订阅接口时传递的createBy）
     * @param data_digest 消息签名
     * @return json格式成功信息
     * @Title: CallBack
     * @Description: 回调方法
     * @return: String 返回类型
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    @ResponseBody
    public String CallBack(String data, String msg_type, String company_id, String data_digest) {
        CallbackEntity callbackEntity = new CallbackEntity();
        TraceEntity resData = JSON.parseObject(data, TraceEntity.class); //消息内容
        String msgType = msg_type; //消息类型
        String companyId = company_id; //合作商ID（为调用订阅接口时传递的createBy）
        String dataDigest = data_digest; //消息签名
        try {
            //获取加密签名
            String key = DigestUtil.digest(data + "", companyId, DigestUtil.UTF8);
            //验签
            key.equals(dataDigest);

            String billCode = resData.getBillCode();//运单号
            String scanType = resData.getScanType();//扫描类型，事件/操作，详情参见scanType编码规范
            String scanSite = resData.getScanSite();//扫描网点
            String scanCity = resData.getScanCity();//扫描城市
            String scanDate = resData.getScanDate();//扫描时间（yyyy-MM-dd HH:mm:ss）
            String desc = resData.getDesc();//物流信息描述
            String contacts = resData.getContacts();//收\派件业务，签收客户名
            String contactsTel = resData.getContactsTel();//收\派件业务电话
            //回调返回设置
            callbackEntity.setMessage("回调成功");
            callbackEntity.setResult("success");
            callbackEntity.setStatus(true);
            callbackEntity.setStatusCode("0");
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info(data + msg_type + company_id + data_digest);
        logger.info(JSON.toJSON(callbackEntity).toString());
        return JSON.toJSON(callbackEntity).toString();
    }

}

//http://localhost:8080/adminsite/fqaInfo/callback?data=&msg_type=&company_id=&data_digest=
//        http://localhost:8080/adminsite/fqaInfo/callback?data=[{%22id%22:%22GPF104291%22,%22billCode%22:%22680000000000%22,%22pushCategory%22:%22callBack%22,%22pushTarget%22:%22http://10.0.5.249:8080/adminsite/fqaInfo/callback%22,%22pushTime%22:1,%22subscriptionCategory%22:63,%22createBy%22:%22test%22,%22isThird%22:null,%22extraPram%22:null,%22createDate%22:null}]&data_digest=n4APXURK39c9ddEVSYTgEQ==&msg_type=SUB&company_id=GPF104291
//        http://localhost:8080/adminsite/fqaInfo/callback?data=[]&data_digest=n4APXURK39c9ddEVSYTgEQ==&msg_type=SU&company_id=GPF104291