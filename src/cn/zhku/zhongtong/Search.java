package cn.zhku.zhongtong;

import com.zto.Util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Search {
    public static void main(String[] args) throws Exception {
        String url = "http://58.40.16.125:9001/zto/api_utf8/orderBatch";
        String url2 = "http://japi.zto.cn/gateway.do";
        Map map = new HashMap();
//        1680000000000
//        ZT1710310000694381
//        534271228492
//        1680000000001，1680000000002，1680000000003，1680000000004
        String data = "[\"680000000000\",\"680000000001\"]";
        map.put("company_id", "GPF104291");
        map.put("msg_type", "TRACEINTERFACE_NEW_TRACES");
        map.put("data", data);
        map.put("data_digest", com.zto.Util.DigestUtil.digest(data, "MIzc2lnbndoeA==", "UTF-8"));
        System.out.println(data);
        System.out.println("url----->" + url2);

        try {
            System.out.println(HttpUtil.post(url2, "UTF-8", map));
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }
}
