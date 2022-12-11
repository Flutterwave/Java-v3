package com.flutterwave.client;

import com.flutterwave.bean.ChargeTypes;
import com.flutterwave.bean.Verb;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.flutterwave.bean.Verb.*;
import static com.flutterwave.metric.Metric.send;

public class Client {
    public static String runTransaction(String url, String request, Verb type,
                                        ChargeTypes chargeType, List<NameValuePair> nameValuePairs) {
        StringBuilder result = new StringBuilder();
        CloseableHttpClient client = HttpClientBuilder.create().build();
        CloseableHttpResponse closeableHttpResponse;
//        new Thread(() -> send(chargeType)).start();
        send(chargeType);

        try {
            URI uri;
            if(nameValuePairs != null){
                uri = new URIBuilder(url)
                        .addParameters(nameValuePairs)
                        .build();

                url= uri.toString();
            }

            System.out.println(url);
            
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
                return client.execute(post);
            } else if (type == PUT) {
                HttpPut put = (HttpPut) httpUriRequest;
                put.setEntity(entity);
                return client.execute(put);
            }
        }
        return client.execute(httpUriRequest);
    }
}
