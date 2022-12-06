package com.flutterwave.client;

import com.flutterwave.bean.Verb;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import static com.flutterwave.bean.Verb.*;

public class Client {
    public static String runTransaction(String url, String request, Verb type) {
        System.out.println(url);
        StringBuilder result = new StringBuilder();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse closeableHttpResponse;
        try {
            closeableHttpResponse = switch (type) {
                case POST -> setValues(new HttpPost(url), client, request, type);
                case GET -> setValues(new HttpGet(url), client, request, type);
                case PUT -> setValues(new HttpPut(url), client, request, type);
                case DELETE -> setValues(new HttpDelete(url), client, request, type);
            };
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

    private static CloseableHttpResponse setValues(HttpUriRequest httpUriRequest,
                                                   CloseableHttpClient client,
                                                   String request, Verb type) throws IOException {
        httpUriRequest.setHeader("Authorization", "Bearer " + System.getProperty("secretKey"));
        httpUriRequest.setHeader("Content-Type", "application/json");
        if(request != null){
            StringEntity entity = new StringEntity(request);
            entity.setContentType(type.toString());
            if(type == POST){
                HttpPost post = (HttpPost) httpUriRequest;
                post.setEntity(entity);
                return client.execute(httpUriRequest);
            } else if (type == PUT) {
                HttpPut put = (HttpPut) httpUriRequest;
                put.setEntity(entity);
                return client.execute(httpUriRequest);
            }
        }
        return client.execute(httpUriRequest);
    }
}
