package cn.zhku.ali;

/**
 * 获取查询接口
 */

import cn.zhku.ali.util.HttpUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

public class ExpressQueryDemo {
    public final static String host = "http://jisukdcx.market.alicloudapi.com";
    public static final String number = "459582039048";
    public static final String type = "auto";

    public static void main(String[] args) throws Exception {
        String path = "/express/query";
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("Authorization", "APPCODE 0d67094e533e4657ad2f8ba8dc33078f");

        // 请求的query
        Map<String, String> querys = new HashMap<String, String>();
        querys.put("number", number);
        querys.put("type", type);
        try {
            HttpResponse response = HttpUtils.doGet(host, path, "GET", headers, querys);
            // response Head
            // System.out.println(response.toString());
            String result = EntityUtils.toString(response.getEntity());
            JSONObject json = JSONObject.fromObject(result);
            if (json.getInt("status") != 0) {
                System.out.println(json.getString("msg"));
            } else {
                JSONObject resultarr = json.optJSONObject("result");
                if (resultarr != null) {
                    if (resultarr.getInt("issign") == 1) {
                        System.out.println("已签收");
                        if (resultarr.opt("list") != null) {
                            JSONArray list = resultarr.optJSONArray("list");
                            for (int j = 0; j < list.size(); j++) {
                                JSONObject list_obj = (JSONObject) list.opt(j);
                                if (list_obj != null) {
                                    String time = list_obj.getString("time");
                                    String status = list_obj.getString("status");
                                    System.out.println(time + " " + status);
                                }
                            }
                        }
                    } else {
                        System.out.println("未签收");
                        if (resultarr.opt("list") != null) {
                            JSONArray list = resultarr.optJSONArray("list");
                            for (int j = 0; j < list.size(); j++) {
                                JSONObject list_obj = (JSONObject) list.opt(j);
                                if (list_obj != null) {
                                    String time = list_obj.getString("time");
                                    String status = list_obj.getString("status");
                                    System.out.println(time + " " + status);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
