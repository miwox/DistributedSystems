package assignment3;


import static assignment3.JsonFactory.ADD_RECORD;
import static assignment3.JsonFactory.GET_RECORD;
import static assignment3.JsonFactory.GET_SIZE;
import static assignment3.JsonFactory.INDEX;
import static assignment3.JsonFactory.METHOD;
import static assignment3.JsonFactory.PARAMS;
import static assignment3.JsonFactory.buildRpcJson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import javax.json.Json;

public class HttpRpcClientComponent {


  public static final String HTTP_LOCALHOST_8000 = "http://localhost:8000/";


  private static HttpRequest buildJsonPostRequest(String json) {
    return HttpRequest.newBuilder().uri(URI.create(HTTP_LOCALHOST_8000))
        .POST(BodyPublishers.ofString(json)).build();
  }


  public static void getSize() throws IOException, InterruptedException {

    String json = buildRpcJson().add(METHOD, GET_SIZE).build().toString();
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = buildJsonPostRequest(json);
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("Response in Client.getSize: " + response.body());
  }

  public static void addRecord(int index, String name) throws IOException, InterruptedException {
    String json = buildRpcJson().add(METHOD, ADD_RECORD)
        .add(PARAMS, Json.createObjectBuilder().add(INDEX, index).add(JsonFactory.NAME, name))
        .build().toString();

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = buildJsonPostRequest(json);
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("Response in Client.addRecord: " + response.body());
  }

  public static void getRecord(int index) throws IOException, InterruptedException {
    String json = buildRpcJson().add(METHOD, GET_RECORD)
        .add(PARAMS, Json.createObjectBuilder().add(INDEX, index))
        .build().toString();

    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = buildJsonPostRequest(json);
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println("Response in Client.getRecord: " + response.body());
  }


}
