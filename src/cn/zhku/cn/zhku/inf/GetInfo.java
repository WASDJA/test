package cn.zhku.cn.zhku.inf;


import sun.misc.BASE64Encoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

public class GetInfo {
    public static final String GBK="GBK";
    public static final String UTF8="UTF-8";
    public static void main(String[] args) {
        String ac =  postZTO("ZT1710310000694381");
    }
    public static String postZTO(String Jobno) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        String di = "";
        try {
            //JSON
            di = encryptBASE64(encryptMD5(("['"+Jobno+"']" + "Key").getBytes(UTF8)));
        } catch (Exception e1) {
            e1.printStackTrace();
        }
        String url = "http://japi.zto.cn/gateway.do";
        String param =  "data=['"+ Jobno +"']&data_digest=" + di + "&msg_type=xxxxxx&company_id=xxxx&billCodes=" + Jobno + "";
        try {
            URL realUrl = new URL(url);
            HttpURLConnection conn = null;
            conn = (HttpURLConnection) realUrl.openConnection();
            // 打开和URL之间的连接
            // 发送POST请求必须设置如下两行
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestMethod("POST"); // POST方法
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");
            conn.connect();
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            out.write(param);
            out.flush();
            in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
            if (result.trim().length() > 0) {
                String abc = result;//接收到的请求返回信息，然后自己解析得到自己想要的信息
                System.out.print(abc);
            }
        } catch (Exception e) {
            System.out.println("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        }
        finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * MD5
     * @param data
     * @return
     * @throws Exception
     */
    public static byte[] encryptMD5(byte[] data) throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        md5.update(data);
        return md5.digest();
    }

    /**
     * base64
     * @param md5
     * @return
     * @throws Exception
     */
    public static String encryptBASE64(byte[] md5) throws Exception {
        return (new BASE64Encoder()).encodeBuffer(md5);
    }
}