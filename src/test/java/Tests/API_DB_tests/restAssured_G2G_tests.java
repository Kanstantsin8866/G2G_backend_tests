package Tests.API_DB_tests;

import io.restassured.response.ResponseBody;
//import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.*;

public class restAssured_G2G_tests {

    //initial GET request test for 'userId' column
    @Test
    public void restGet_test() throws InterruptedException {

        baseURI = "http://0.0.0.0:3000";
        List<Integer> codeNumbers = new ArrayList<>();
        List<Integer> code_2xx = new ArrayList<>();
        List<Integer> code_3xx = new ArrayList<>();
        List<Integer> code_4xx = new ArrayList<>();
        List<Integer> code_5xx = new ArrayList<>();
        int id;

        //looping through 100 users in our psqlDB by invoking Node JS server
        for (id = 0; id < 100; id++) {
            int statusCode;
            RequestSpecification httpRequest = RestAssured.given();
            Response response = httpRequest.get("/user/v1/" + id);
            ResponseBody body = response.getBody();

            statusCode = response.getStatusCode();

            Thread.sleep(1000);
            if (statusCode > 299) {

                System.out.println("This id-> " + id + " has Code status: " + statusCode + "'" + body.asString() + "'");
                codeNumbers.add(statusCode);
            } else {
                System.out.println("This id -> " + id + " has code:" + statusCode);
                codeNumbers.add(statusCode);

            }
        }
        System.out.println("FINAL Statuscode's log: " + codeNumbers);

        //sorting status CODES by their numbers in an array
        for (Integer codeNumber : codeNumbers)
            if (codeNumber < 299)
                code_2xx.add(codeNumber);
            else if (codeNumber > 299 && codeNumber < 399)
                code_3xx.add(codeNumber);
            else if (codeNumber > 399 && codeNumber < 499)
                code_4xx.add(codeNumber);
            else if (codeNumber > 499)
                code_5xx.add(codeNumber);
        System.out.println("Code  2xx : " + code_2xx.size() + " count");
        System.out.println("Code 3xx: " + code_3xx.size() + " count");
        System.out.println("Code 4xx: " + code_4xx.size() + " count");
        System.out.println("Code 5xx: " + code_5xx.size() + " count");

    }
}
