package com.zzq.learn.ago.learn.test;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpUtil;
import cn.hutool.http.Method;

import java.util.Map;

public class KongAdminDao {
    private KongAdminDao() {
    }

    KongAdminDao(String path) {
        this.path = path;
    }

    private final static String baseUrl = "http://localhost:8001/";
    public String path;

    public String create(Map<String, Object> paramMap) {
        return HttpUtil.post(baseUrl + "/" + path, paramMap);
    }

    public String list() {
        return HttpUtil.get(baseUrl + path);
    }

    /**
     * @param key name or id
     * @return jsonStr
     */
    public String getByKey(String key) {
        return HttpUtil.get(baseUrl + path + "/" + key);
    }

    public String delete() {
        return HttpUtil.createRequest(Method.DELETE, baseUrl + path).execute().body();
    }

    public String update(Map<String, Object> paramMap) {
        HttpRequest request = HttpUtil.createRequest(Method.PATCH, baseUrl + path);
        request.form(paramMap);
        return request.execute().body();
    }

    public String updateOrCreate(Map<String, Object> paramMap) {
        HttpRequest request = HttpUtil.createRequest(Method.PUT, baseUrl + path);
        request.form(paramMap);
        return request.execute().body();
    }
}
