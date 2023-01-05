package com.flutterwave.metric;

import com.flutterwave.bean.ChargeTypes;
import com.flutterwave.client.Client;
import org.json.JSONObject;

import static com.flutterwave.bean.ChargeTypes.DEFAULT;
import static com.flutterwave.bean.Verb.POST;

/**
 * Handles sending metric data to assist F4B make the sdk and API better where needed.
 * @author cleopatradouglas
 */
public class Metric {

    /**
     * sends the metric data needed
     * @param type of charge
     */
    public static void send(ChargeTypes type) {
        //validate public key is set in environment
        if (System.getProperty("publicKey") == null) {
            throw new RuntimeException("please set your public key in the environment");
        }

        if (type != DEFAULT) {
            JSONObject request = new JSONObject();
            request.put("publicKey", System.getProperty("publicKey"));
            request.put("language", "JAVA");
            request.put("version", "V2");
            request.put("title", "incoming request");
            request.put("message", type.toString());

            Client.runTransaction(
                    "https://kgelfdz7mf.execute-api.us-east-1.amazonaws.com/staging/sendevent",
                    request.toString(),
                    POST, DEFAULT, null);
        }
    }
}
