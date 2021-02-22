package testdefs;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;

public class CalculateApiHelper {

    HttpResponse<JsonNode> response;

    public HttpResponse<JsonNode> doPostRequest(String body, String uri) {

        System.out.println("Request to: " + uri);
        System.out.println("Request body: " + body);

        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();

        HttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
        Unirest.setHttpClient(httpclient);

        try {
            response = Unirest.post(uri)
                    .header("Content-Type", "application/json")
                    .body(body)
                    .asJson();
            if (response.getStatus() != 200) {
                throw new Error("Request failed with code " + response.getStatus());
            }
        } catch (UnirestException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Response: " + response.getBody().toString());
        return response;
    }
}
