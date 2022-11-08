package assignment3;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

public class HttpRpcHandler implements HttpHandler {

  @Override
  public void handle(HttpExchange exchange) throws IOException {
    String httpMethod = exchange.getRequestMethod();

    if (httpMethod.equals("GET")) {
      String numberOfRecord = exchange.getRequestHeaders().getFirst("value");
      if (numberOfRecord != null) {
        writeRecordOnOutputStream(exchange, Integer.parseInt(numberOfRecord));
      } else {
        writeSizeOnOutputStream(exchange);
      }
    } else {
      changeDatabase(exchange);
    }
  }

  private static void changeDatabase(HttpExchange exchange) throws IOException {

  }


  private static void writeSizeOnOutputStream(HttpExchange exchange) throws IOException {
    String response = "" + HttpRpcServer.getSize();
    exchange.sendResponseHeaders(200, response.length());
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }

  private static void writeRecordOnOutputStream(HttpExchange exchange, int parseInt)
      throws IOException {
    String response = "Ausgabe des Records am index: " + parseInt;
    exchange.sendResponseHeaders(200, response.length());
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();
  }
}
