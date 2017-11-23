package cn.zhku.ali;

/**
 * 获取快递公司接口
 */

import cn.zhku.ali.util.HttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class ExpressTypeDemo {
    public final static String host = "http://jisukdcx.market.alicloudapi.com";

    public static void main(String[] args) throws Exception {
        String path = "/express/type";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE 0d67094e533e4657ad2f8ba8dc33078f");

        // 请求的query
        Map<String, String> querys = new HashMap<String, String>();

        try {
            HttpResponse response = HttpUtils.doGet(host, path, "GET", headers, querys);
            // response Head
            // System.out.println(response.toString());
            String result = EntityUtils.toString(response.getEntity());
            JSONObject json = JSONObject.fromObject(result);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONArray resultarr = json.optJSONArray("result");
                for (int i = 0; i < resultarr.size(); i++) {
                    JSONObject obj = (JSONObject) resultarr.opt(i);
                    String name = obj.getString("name");
                    String type = obj.getString("type");
                    String letter = obj.getString("letter");
                    String tel = obj.getString("tel");
                    String number = obj.getString("number");
                    System.out.println(name + " " + type + " " + letter + " " + tel + " " + number);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
