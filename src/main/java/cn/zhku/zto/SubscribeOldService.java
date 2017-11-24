package cn.zhku.zto;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: SubscribeOldService
 * @Description: 通过运单号订阅类
 * @author: heyang
 * @date: 2017年6月12日 下午1:20:07
 */
public class SubscribeOldService {
    private final static Logger logger = LoggerFactory.getLogger(CallBack.class);

    /**
     * @throws Exception
     * @Title: sub
     * @Description: 订阅方法
     * @return: void 返回类型
     */
    @SuppressWarnings({"deprecation", "resource"})
    public static void sub() {
        final String url = "http://58.40.16.125:9001/zto/api_utf8/subBillLog";
        try {
            String data = "";
            String data_digest = "";
            String msg_type = "SUB";
            String company_id = "zto";
            List<SubscribeData> josnList = new ArrayList<SubscribeData>();
            SubscribeData subscribeData = new SubscribeData();
            subscribeData.setId("1111111111");
            subscribeData.setBillCode("680000000020");
            subscribeData.setPushCategory("callBack");
            subscribeData.setPushTarget("http://10.9.20.74:8080/");
            subscribeData.setPushTime((short) 1);
            subscribeData.setSubscriptionCategory((short) 63);
            subscribeData.setCreateBy("test");
            josnList.add(subscribeData);
            data = JSON.toJSONString(josnList);
            data_digest = DigestUtil.digest((data), "123456", "utf-8");
            HttpPost httpPost = new HttpPost(url);
            //建立一个NameValuePair数组，用于存储欲传递的参数
            List<BasicNameValuePair> params = new ArrayList<BasicNameValuePair>();
            //添加参数
            params.add(new BasicNameValuePair("data", data));
            params.add(new BasicNameValuePair("data_digest", data_digest));
            params.add(new BasicNameValuePair("msg_type", msg_type));
            params.add(new BasicNameValuePair("company_id", company_id));
            httpPost.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
            HttpClient client = new DefaultHttpClient();
            HttpResponse httpResponse = client.execute(httpPost);
            String result = EntityUtils.toString(httpResponse.getEntity(), HTTP.UTF_8);
            logger.info(data);
            logger.info(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        SubscribeOldService.sub();
    }
}
