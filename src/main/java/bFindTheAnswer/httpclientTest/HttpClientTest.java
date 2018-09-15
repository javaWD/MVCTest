package bFindTheAnswer.httpclientTest;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpClientTest {
    public static void main(String[] args) throws ParseException, IOException{
        String url="https://hk.lanmaoly.com/bha-neo-app/lanmaotech/service";
        Map<String, String> map = new HashMap<>();
        map.put("serviceName", "QUERY_USER_INFORMATION");
        map.put("platformNo", "9000000001");
        map.put("reqData", "{\"platformUserNo\":\"wdtestpoor051701\",\"timestamp\":\"20180502145753\",\"platformNo\":\"9000000001\"}");
        map.put("sign", "pbg2YYHjk4gBB0hmkfM2bX2ZpM9lbsrMVuIFafPey30qlx0mRwz9METTJm8wS3rdn69kWdOz4vL5kgrJqxxtiOSv2Rk72bUnZkLqxFJaKrIbQZBOq25mvTPI96WVsWQgaRtLjuWx2+z8TcnYrpIJ+KTrV/8xs2C+8cfpQcZ/tCzTTwLEc8/jD6t+pfZKqBkJ/SgTpvt3AvsSuMnrYD2A3qQVdXhQ+nBp517Yti1eeCm01R3QuOcmQ/8XrScFjuYmhSMYyD7Zx6sSn9BUVkihG5H7iN75Zvt7hLantDj8QDFiciO3kHwLBQq2Hmu1IIb1SQE35ZICuW3e+cbLILnPPQ==");
        map.put("keySerial", "1");
        SimpleHttpClientDemo shcd=new SimpleHttpClientDemo();
        String body = shcd.send(url, map,"utf-8");
        System.out.println("交易响应结果：");
        System.out.println(body);

        System.out.println("-----------------------------------");

    }



    /**
     * @method  testGetAToken
     * @description
     * 测试获取token
     * @param []
     * @return void
     * @date  2018/9/3 16:33
     * @author  drudg
     */
    @Test
    public void testGetAToken() throws ParseException, IOException{

        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx21e9c30175892c78&secret=0cb6ce99bd07c50775df8758a15589bb";
        String grant_type="client_credential";
        String appid="wx21e9c30175892c78";
        String secret="0cb6ce99bd07c50775df8758a15589bb";

        Map<String, String> map = new HashMap<>();
        SimpleHttpClientDemo shcd=new SimpleHttpClientDemo();

        String body = shcd.send(url, map,"utf-8");

        System.out.println("交易响应结果：");
        System.out.println(body);

    }

    @Test
        /* *
         *  @method  stringToJson
         *  @description 测试获取token返回结果，将string转为json。
         *  @param []
         *  @return void
         *  @date  2018/9/3 18:03
         *  @author  drudg
         * */
    public void stringToJson(){
        String jsonStr="{\"access_token\":\"13_tbCy4IvI4H9U_3o_ZMq56W0o11bLLdv2ACJPxXcCYA0nVHwRvtRw0JBVBT7A0h1MYJx4kvYczI9-pAtqY8Lmgkt5HD37gZcleLpsALb8V94gO4z4Vqe0k4JCdGlJ5HdgOSVi4_0ne_SLTNScSXCgACAVAF\",\"expires_in\":7200}\n";
        JsonObject returnData = new JsonParser().parse(jsonStr).getAsJsonObject();
        JsonElement je=returnData.get("expires_in");

        System.out.println(je);
    }


}


/**
 * 简单httpclient实例
 *
 * @author arron
 * @date 2015年11月11日 下午6:36:49
 * @version 1.0
 */
 class SimpleHttpClientDemo {

    /**
     * 模拟请求
     *
     * @param url		资源地址
     * @param map	参数列表
     * @param encoding	编码
     * @return
     * @throws ParseException
     * @throws IOException
     */
    public static String send(String url, Map<String,String> map, String encoding) throws ParseException, IOException{
        String body = "";

        //创建httpclient对象
        CloseableHttpClient client = HttpClients.createDefault();
        //创建post方式请求对象
        HttpPost httpPost = new HttpPost(url);

        //装填参数
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        if(map!=null){
            for (Map.Entry<String, String> entry : map.entrySet()) {
                nvps.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
            }
        }
        //设置参数到请求对象中
        httpPost.setEntity(new UrlEncodedFormEntity(nvps, encoding));


        System.out.println("请求地址："+url);
        System.out.println("请求参数："+nvps.toString());

        //设置header信息
        //指定报文头【Content-type】、【User-Agent】
        httpPost.setHeader("Content-type", "application/x-www-form-urlencoded");
        httpPost.setHeader("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");

        //执行请求操作，并拿到结果（同步阻塞）
        CloseableHttpResponse response = client.execute(httpPost);
        //获取结果实体
        HttpEntity entity = response.getEntity();
        if (entity != null) {
            //按指定编码转换结果实体为String类型
            body = EntityUtils.toString(entity, encoding);
        }
        EntityUtils.consume(entity);
        //释放链接
        response.close();
        return body;
    }
}
