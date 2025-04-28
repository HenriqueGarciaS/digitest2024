package com.example;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.swing.text.html.parser.Entity;
import java.net.http.HttpClient;

/**
 * This task expects you to create an implementation of a Rest API client.
 * Your code should call the API endpoint related below.
 * After receiving the JSON Response, print out how many records exists for each gender
 * API endpoint => https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda 
 * 
 * >>> Bonus <<<
 * Generate a CSV file containing many records exists for each gender and save this file to AWS S3 Bucket
 * The filename need to contains your entire name, separated by uderscore. Example: john_lennon.csv
 * AWS S3 bucket name => interview-digiage
 * The credentials you can find in Coodesh platform or ask via e-mail for recrutamento@digiage.com.br
 */

public class RESTAPIClientTask {

    // API endpoint => https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda

    public static void main(String[] args){
        try{
            CloseableHttpClient httpClient = HttpClients.createDefault();
            HttpGet request = new HttpGet("https://3ospphrepc.execute-api.us-west-2.amazonaws.com/prod/RDSLambda");
            CloseableHttpResponse response = httpClient.execute(request);

            HttpEntity entity = response.getEntity();
            System.out.println(EntityUtils.toString(entity));
            // Está retornando {"errorType":"Runtime.ExitError","errorMessage":"RequestId: fe79a8ef-5447-43a7-8c3f-767e67c88aa0 Error: Runtime exited without providing a reason"}

        }catch(Exception e){

        }
    }
}