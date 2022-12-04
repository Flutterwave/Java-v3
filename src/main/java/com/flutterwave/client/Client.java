package com.flutterwave.client;

import com.flutterwave.bean.Verb;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static com.flutterwave.bean.Verb.GET;
import static com.flutterwave.bean.Verb.POST;

public class Client {

    public static String runTransaction(String url, String request, Verb type) {
        System.out.println(request);
        System.out.println(url);
        StringBuilder result = new StringBuilder();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse closeableHttpResponse = null;
        try {
            if (type == POST) {
                HttpPost post = new HttpPost(url);
                post.setHeader("Authorization", "Bearer " + System.getProperty("secretKey"));
                post.setHeader("Content-Type", "application/json");
                StringEntity entity = new StringEntity(request);
                entity.setContentType(type.toString());
                post.setEntity(entity);
                closeableHttpResponse = client.execute(post);
            } else if (type == GET) {
                HttpGet get = new HttpGet(url);
                get.setHeader("Authorization", "Bearer " + System.getProperty("secretKey"));
                get.setHeader("Content-Type", "application/json");
                closeableHttpResponse = client.execute(get);
            }
            BufferedReader rd = new BufferedReader(new InputStreamReader(closeableHttpResponse.getEntity().getContent()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            return result.toString();
        } catch (Exception e) {
            return null;
        }
    }

    private Map<String, String> header() {
        Map<String, String> head = new HashMap<>();
        head.put("Authorization", "Bearer " + System.getenv("secretKey"));
        return head;
    }
}
