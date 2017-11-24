package cn.zhku.zhongtong;

import com.zto.Util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CancelOrderTest {
    public static void main(String[] args) throws Exception {
        String url = "http://58.40.16.125:9001/zto/api_utf8/orderBatch";
        Map map = new HashMap();
        String data = "[\n" +
                "{\n" +
                "\"companyCode\": \"GPF104291\",\n" +
                "\"fieldName\": \" status\",\n" +
                "\"fieldValue\": \" cancel\",\n" +
                "\"partnerCode\": \"420182225124\",\n" +
                "\"reason\": \"取消\n" +
                "\"\n" +
                "},\n" +
                "{\n" +
                "\"companyCode\": \"GPF104291\",\n" +
                "\"fieldName\": \" status\",\n" +
                "\"fieldValue\": \" cancel\",\n" +
                "\"partnerCode\": \"420182225124\",\n" +
                "\"reason\": \"取消\n" +
                "\"\n" +
                "}\n" +
                "]";

        map.put("company_id", "GPF104291");
        map.put("msg_type", "platformOrderCancel");
        map.put("data", data);
        map.put("data_digest", com.zto.Util.DigestUtil.digest(data, "MIzc2lnbndoeA==", "UTF-8"));
        System.out.println(data);

        try {
            System.out.println(HttpUtil.post(url, "UTF-8", map));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }
}
