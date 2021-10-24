package common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import pages.browser;

import java.io.*;
import java.util.HashMap;
import java.util.Locale;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/*---------------------------------------------------------------------------------------
    Created By : Arun Ganesh
    Date : 24-10-2021
    class for all common utilities used across the project
 */

public class commonUtils {
    /*---------------------------------------------------------------------------------------
    Created By : Arun Ganesh
    Date : 24-10-2021
    to read environment properties from properties file
    */
    public static String readProperties(String propkey) {
        String basedir = System.getProperty("user.dir");
        Properties prop = new Properties();
        String retval = "";
        InputStream input = null;
        try {
            input = new FileInputStream("./src/test/resources/environment.properties");
            prop.load(input);
            retval = prop.getProperty(propkey);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return retval;
    }
    /*---------------------------------------------------------------------------------------
    Created By : Arun Ganesh
    Date : 24-10-2021
    to get the operating system type to select the correct driver.
    */
    public static String getOSType()
    {
       String os = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
       return  os;

    }
     /*---------------------------------------------------------------------------------------
        Created By : Arun Ganesh
        Date : 24-10-2021
        to fire get request using rest assured.
       */

    public static Response fireGetRequest(String url, HashMap<String,String> params,HashMap<String,String> headers)
    {
        Response response = (Response) RestAssured.given().request()
                .headers(headers)
                .when().params(params)
                .get(url)
                .then().extract().response();
        return response;
    }

    /*---------------------------------------------------------------------------------------
        Created By : Arun Ganesh
        Date : 24-10-2021
        parse JSON and get temperature value
       */

    public static String getTempValueFromJson(String jsonString) throws ParseException {

        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(jsonString);
        JSONObject mainJsonObj = (JSONObject)jsonObj.get("main");
        String valueFromPath = mainJsonObj.get("temp").toString();
        return valueFromPath;
    }

     /*---------------------------------------------------------------------------------------
        Created By : Arun Ganesh
        Date : 24-10-2021
        Parse json and get location details
       */

    public  static  String getLocationFromJSON(String jsonString) throws ParseException{
        JSONParser parser = new JSONParser();
        JSONObject jsonObj = (JSONObject) parser.parse(jsonString);
        String locationValue = jsonObj.get("name").toString();
        return locationValue;

    }

    /*---------------------------------------------------------------------------------------
        Created By : Arun Ganesh
        Date : 24-10-2021
        Kill Selenium web driver
       */

    public static void killDriver()
    {
        try{
            browser.driver.quit();
        }
        catch(Exception e)
        {

        }
    }
}

