/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.vocabularymaster.utils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

/**
 *
 * @author papar
 */
public class ApiHandler {
    
    public static String getRandomWord(){
        String response = "";
        try {
            var request = HttpRequest
                .newBuilder()
                .uri(new URI("https://api.api-ninjas.com/v1/randomword"))
                .GET()
                .header("X-Api-Key", "SglAKP8N3zsRPWy0jJqoxg==vWdMl4bQtMYCtsMC")
                .build();
            var client = HttpClient.newHttpClient();
            var httpResponse = client.send(request, HttpResponse.BodyHandlers.ofString());
            response = httpResponse.body().split("\"")[3];
        } catch (IOException | InterruptedException | URISyntaxException e) {
            System.out.println(e.getMessage());
        }
        return response;
    }
}
