package cn.zhku.zhongtong;

import com.zto.Util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SUBtest {
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        String url = "http://58.40.16.125:9001/zto/api_utf8/subBillLog";
        String data = "[{\n" +
                "     \"id\": \"1111111111\",\n" +
                "     \"billCode\": \"700000000\",\n" +
                "     \"pushCategory\": \"callBack\",\n" +
                "     \"pushTarget\": \"122.138.1.13:8080/shangjia/traces\",\n" +
                "     \"pushTime\": 1,\n" +
                "     \"subscriptionCategory\": 63,\n" +
                " \"createBy\": \"XXX\",\n" +
                "},{\n" +
                "     \"id\": \"1111111112\",\n" +
                "     \"billCode\": \"7000000001\",\n" +
                "     \"pushCategory\": \"callBack\",\n" +
                "     \"pushTarget\": \"122.138.1.13:8080/shangjia/traces\",\n" +
                "    \"pushTime\": 1,\n" +
                "    \"subscriptionCategory\": 63,\n" +
                "  \"createBy\": \"XXX\"\n" +
                "},{\n" +
                "    \"id\": \"1111111113\",\n" +
                "     \"billCode\": \"7000000002\",\n" +
                "     \"pushCategory\": \"callBack\",\n" +
                "     \"pushTarget\": \"122.138.1.13:8080/shangjia/traces\",\n" +
                "     \"pushTime\": 1,\n" +
                "     \"subscriptionCategory\": 63,\n" +
                " \"createBy\": \"XXX\"\n" +
                "}]";
        map.put("company_id", "GPF104291");
        map.put("msg_type", "SUB");
        map.put("data", data);
        map.put("data_digest", com.zto.Util.DigestUtil.digest(data, "GPF104291", "UTF-8"));


        try {
            System.out.println(HttpUtil.post(url, "UTF-8", map));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }
}
