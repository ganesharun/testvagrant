package steps;

import common.commonUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import reportFactory.logs;
import Exception.apiRequestFailException;
import static org.assertj.core.api.Assertions.*;



import java.util.HashMap;

public class apiTests {
    logs oLog = new logs();
    double apiTemp = 0.0;

    @And("get the api temperature details from the api for the {string}")
    public void apiTest(String location) throws apiRequestFailException, ParseException {
        String apiBaseURL = commonUtils.readProperties("apiBaseURL");
        HashMap<String,String> requestHeaders = new HashMap<>();
        HashMap<String,String> requestParameters = new HashMap<>();
        requestHeaders.put("Connection","keep-alive");
        requestParameters.put("q",location);
        requestParameters.put("appid", commonUtils.readProperties("appID"));
        requestParameters.put("units", "metric");
        Response response = commonUtils.fireGetRequest(apiBaseURL,requestParameters,requestHeaders);
        if(response.statusCode() != 200)
        {
            throw new apiRequestFailException("The API Request responded with status code not equal to 200");
        }
        assertThat(commonUtils.getLocationFromJSON(response.asString()).toLowerCase()).contains(location.toLowerCase());
        oLog.info("Get Request Fired and the response is : "+ response.asString());
        apiTemp = Double.parseDouble(commonUtils.getTempValueFromJson(response.asString()));
    }
}
