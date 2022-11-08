package assignment3;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.Builder;
import java.net.http.HttpResponse;
import javax.json.Json;
import javax.json.JsonObject;

public class HttpRpcClientComponent {


  public static final String HTTP_LOCALHOST_8000 = "http://localhost:8000/";

  private static Builder getBuilder() {
    return HttpRequest.newBuilder().uri(URI.create(HTTP_LOCALHOST_8000));
  }

  public static void requestSize() throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = getBuilder().GET().build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
  }

  public static void getRecord(int index) throws IOException, InterruptedException {
    HttpClient client = HttpClient.newHttpClient();
    HttpRequest request = getBuilder().GET().setHeader("value", "" + index).build();
    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
    System.out.println(response.body());
  }

  public static void updateRecord(int index, String name) {

  }
}
