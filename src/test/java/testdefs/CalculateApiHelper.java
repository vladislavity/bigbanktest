package testdefs;

import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;

public class CalculateApiHelper {

    HttpResponse<JsonNode> response;
    public static String CALCULATE_URI = "https://ansokan.bigbank.se/api/v1/loan/calculate";

    public HttpResponse<JsonNode> calculateRequest(int amount, int month) {

        String body = new JSONObject()
                .put("administrationFee", 40)
                .put("conclusionFee", 695)
                .put("currency", "SEK")
                .put("interestRate", 10.95)
                .put("monthlyPaymentDay", 27)
                .put("productType", "LOANSE02")
                .put("amount", amount)
                .put("maturity", month)
                .toString();

        System.out.println("Request body: " + body);

        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.IGNORE_COOKIES).build();
        HttpClient httpclient = HttpClients.custom().setDefaultRequestConfig(globalConfig).build();
        Unirest.setHttpClient(httpclient);

        System.out.println("Request to: " + CALCULATE_URI);

        try {
            response = Unirest.post(CALCULATE_URI)
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

    public String parseCalculateResponse(String response, String queue) {
        DocumentContext json = JsonPath.parse(response);
        String jsonText = json.read(queue).toString();
        return jsonText;
    }
}