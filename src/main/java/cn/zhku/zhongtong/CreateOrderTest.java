package cn.zhku.zhongtong;

import com.zto.Util.DigestUtil;
import com.zto.Util.HttpUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CreateOrderTest {
    //    GPJ10123
    public static void main(String[] args) throws Exception {
        Map map = new HashMap();
        String url = "http://58.40.16.125:9001/zto/api_utf8/orderBatch";
        String data = "        [{\"partnerCode\": \"420182225124\",\n" +
                " \"companyCode\": \"GPF104291\",\n" +
                " \"startTime\": 1477381760445,\n" +
                " \"endTime\": 1477381760550,\n" +
                " \"weight\": 20,\n" +
                " \"bagSize\": \"23\",\n" +
                " \"price\": \"12\",\n" +
                " \"freight\": \"123456789\",\n" +
                " \"premium\": \"23\",\n" +
                " \"packCharges\": \"12\",\n" +
                " \"otherCharges\": \"123456789\",\n" +
                " \"orderSum\": \"13\",\n" +
                " \"collectMoneytype\": \"￥\",\n" +
                " \"collect_sum\": \"34\",\n" +
                " \"remarks\": \"\",\n" +
                " \"receiver\": {\n" +
                "         \"address\": \"上海市青浦区华新镇\",\n" +
                "         \"area\": \"000\",\n" +
                "         \"prov\": \"上海市\",\n" +
                "         \"city\": \"上海市\",\n" +
                "         \"county\": \"青浦区\",\n" +
                "         \"company\": \"中通\",\n" +
                "         \"email\": \"123456789@qq.com\",\n" +
                "         \"id\": \"001\",\n" +
                "         \"im\": \"手机\",\n" +
                "         \"mobile\": \"13233339836\",\n" +
                "         \"name\": \"张三\",\n" +
                "         \"phone\": \"021-542376**\",\n" +
                "         \"zipcode\": \"710600\"\n" +
                " },\n" +
                " \"sender \": {\n" +
                "         \"address\": \"上海市青浦区华新镇\",\n" +
                "         \"area\": \"000\",\n" +
                "         \"prov\": \"上海市\",\n" +
                "         \"city\": \"上海市\",\n" +
                "         \"county\": \"青浦区\",\n" +
                "         \"company\": \"中通\",\n" +
                "         \"email\": \"123456789@qq.com\",\n" +
                "         \"id\": \"001\",\n" +
                "         \"im\": \"手机\",\n" +
                "         \"mobile\": \"13233339836\",\n" +
                "         \"name\": \"张三\",\n" +
                "         \"phone\": \"021-542376**\",\n" +
                "         \"zipcode\": \"710600\"\n" +
                " },\n" +
                " \"sender\": {\n" +
                "         \"address\": \"上海市青浦区华新镇\",\n" +
                "         \"area\": \"000\",\n" +
                "         \"prov\": \"上海市\",\n" +
                "         \"city\": \"上海市\",\n" +
                "         \"county\": \"青浦区\",\n" +
                "         \"company\": \"中通\",\n" +
                "         \"email\": \"123456789@qq.com\",\n" +
                "         \"id\": \"001\",\n" +
                "         \"im\": \"手机\",\n" +
                "         \"mobile\": \"13233339836\",\n" +
                "         \"name\": \"张三\",\n" +
                "         \"phone\": \"021-542376**\",\n" +
                "         \"zipcode\": \"710600\"\n" +
                " },\n" +
                " \"quantity\": \"2\"\n" +
                " }]";

        map.put("company_id", "GPF104291");
        map.put("msg_type", "platformOrderCreate");
        map.put("data", data);
        map.put("data_digest", DigestUtil.digest(data, "MIzc2lnbndoeA==", DigestUtil.UTF8));
        System.out.println(data);
        try {
            System.err.println(HttpUtil.post(url, "UTF-8", map));
        } catch (IOException var4) {
            var4.printStackTrace();
        }
    }
}
//[{"partnerCode": "420182225124",
// "companyCode": "GPF104291",
// "startTime": 1477381760445,
// "endTime": 1477381760550,
// "weight": 20,
// "bagSize": "23",
// "price": "12",
// "freight": "123456789",
// "premium": "23",
// "packCharges": "12",
// "otherCharges": "123456789",
// "orderSum": "13",
// "collectMoneytype": "￥",
// "collect_sum": "34",
// "remarks": "",
// "receiver": {
// "address": "上海市青浦区华新镇",
// "area": "000",
// "prov": "上海市",
// "city": "上海市",
// "county": "青浦区",
// "company": "中通",
// "email": "123456789@qq.com",
// "id": "001",
// "im": "手机",
// "mobile": "13233339836",
// "name": "张三",
// "phone": "021-542376**",
// "zipcode": "710600"
// },
// "sender ": {
// "address": "上海市青浦区华新镇",
// "area": "000",
// "prov": "上海市",
// "city": "上海市",
// "county": "青浦区",
// "company": "中通",
// "email": "123456789@qq.com",
// "id": "001",
// "im": "手机",
// "mobile": "13233339836",
// "name": "张三",
// "phone": "021-542376**",
// "zipcode": "710600"
// },
// "sender": {
// "address": "上海市青浦区华新镇",
// "area": "000",
// "prov": "上海市",
// "city": "上海市",
// "county": "青浦区",
// "company": "中通",
// "email": "123456789@qq.com",
// "id": "001",
// "im": "手机",
// "mobile": "13233339836",
// "name": "张三",
// "phone": "021-542376**",
// "zipcode": "710600"
// },
// "quantity": "2"
// }]
//   {
// "isSuccess":true,
// "reason":"",
// "response":[{
// "billCode":"130014462396",
// "isupdate":"1",
// "mark":"300- 18-05",
// "message":"",
// "partnerCode":"420182225124",
// "result":"下单成功",
// "sitecode":"02100",
// "sitename":"沪西",
// "status":true,
// "statusCode":"0"
// }]
// }