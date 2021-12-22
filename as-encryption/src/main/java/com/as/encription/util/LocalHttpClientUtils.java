package com.as.encription.util;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import lombok.Data;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

public class LocalHttpClientUtils {

    private static final String CIPHER = "AES";
    // 待麦亚信提供
    private static final String COMPANY = "ACHI";
    // 待麦亚信提供
    private static final String KEY = "key";

    @SuppressWarnings("unchecked")
    public static <E> BaseResponse<E> post(String uri, String reqJson, Class<E> clazz) {
        try {
            CloseableHttpClient httpClient = HttpClientBuilder.create().build();
            HttpPost post = new HttpPost(uri);
            post.setHeader("Content-type", ContentType.APPLICATION_JSON.getMimeType());
            post.setHeader("cipher", CIPHER);
            post.setHeader("company", COMPANY);
            // 请求体通过AES加密
            String encryptJSON = AesBase64Utils.encryptAB(reqJson, KEY);
            StringEntity stringEntity = new StringEntity(encryptJSON, ContentType.APPLICATION_JSON.getCharset());
            post.setEntity(stringEntity);

            String decryptJSON = httpClient.execute(post, LocalHttpClientUtils::responseHandle);
            // 可添加空值判断，抛出相应异常
            return JSONObject.parseObject(decryptJSON, BaseResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static String responseHandle(HttpResponse response) {
        String res = "";
        try {
            final StatusLine statusLine = response.getStatusLine();
            final HttpEntity entity = response.getEntity();
            if (statusLine.getStatusCode() >= 300) {
                EntityUtils.consume(entity);
                throw new HttpResponseException(statusLine.getStatusCode(),
                        statusLine.getReasonPhrase());
            }

            if (null != entity) {
                res = AesBase64Utils.decryptAB(new String(Base64.decode(EntityUtils.toString(entity))), KEY);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return res;
    }

    @Data
    public static class BaseResponse<T> {
        private int code;
        private String desc;
        private T data;
    }
}
