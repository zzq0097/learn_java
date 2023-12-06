package com.zzq.learn.ago.learn.test;

import cn.hutool.http.ContentType;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class WYTest {

    /**
     * 产品密钥ID，产品标识
     */
    private final static String SECRETID = "d6d69b3485675059be3a736a7b71d07c";
    /**
     * 产品私有密钥，服务端生成签名信息使用，请严格保管，避免泄露
     */
    private final static String SECRETKEY = "5ee0d73766ed0faede935530120e7296";
    /**
     * 业务ID，易盾根据产品业务特点分配
     */
    private final static String BUSINESSID = "0947798164dba177341ea7d85d922be5";
    /**
     * 易盾反垃圾云服务审核系统文本批量提交接口
     */
//    private final static String API_URL = "http://as.dun.163.com/v1/text/submit";
    private final static String API_URL = "http://as.dun.163.com/v5/text/check";


    /**
     * @param args
     * @throws Exception
     */
    public String test(String text) throws Exception {
        Map<String, Object> params = new HashMap<>();
        // 1.设置公共参数
        params.put("secretId", SECRETID);
        params.put("businessId", BUSINESSID);
        params.put("version", "v5");
        params.put("timestamp", String.valueOf(System.currentTimeMillis()));
        params.put("nonce", String.valueOf(new Random().nextInt()));
        // MD5, SM3, SHA1, SHA256
        params.put("signatureMethod", "MD5");
        params.put("dataId", "ebfcad1c-dba1-490c-b4de-e784c2691768");
        params.put("content", text);


        // 3.生成签名信息
        String signature = genSignature(SECRETKEY, params);
        params.put("signature", signature);

        HttpRequest request = HttpUtil.createPost(API_URL);
        request.contentType(ContentType.FORM_URLENCODED.getValue());
        request.form(params);

        try (HttpResponse response = request.execute()) {
            System.out.println(response.getStatus());
            return response.body();
        }
    }

    public static String genSignature(String secretKey, Map<String, Object> params) throws Exception {
        // 1. 参数名按照ASCII码表升序排序
        String[] keys = params.keySet().toArray(new String[0]);
        Arrays.sort(keys);

        // 2. 按照排序拼接参数名与参数值
        StringBuilder sb = new StringBuilder();
        for (String key : keys) {
            sb.append(key).append(params.get(key));
        }
        // 3. 将secretKey拼接到最后
        sb.append(secretKey);

        // 4. MD5是128位长度的摘要算法，转换为十六进制之后长度为32字符
        return DigestUtils.md5Hex(sb.toString().getBytes("UTF-8"));
    }
}
