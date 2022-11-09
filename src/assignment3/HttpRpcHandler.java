package assignment3;

import static assignment3.JsonFactory.ADD_RECORD;
import static assignment3.JsonFactory.ERROR_JSON;
import static assignment3.JsonFactory.GET_RECORD;
import static assignment3.JsonFactory.GET_SIZE;
import static assignment3.JsonFactory.INDEX;
import static assignment3.JsonFactory.METHOD;
import static assignment3.JsonFactory.NAME;
import static assignment3.JsonFactory.PARAMS;
import static assignment3.JsonFactory.RESULT;
import static assignment3.JsonFactory.jsonStringToObj;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import javax.json.Json;
import javax.json.JsonObject;

public class HttpRpcHandler implements HttpHandler {


  @Override
  public void handle(HttpExchange exchange) throws IOException {

    String stringBody = new String(exchange.getRequestBody().readAllBytes(),
        StandardCharsets.UTF_8);

    JsonObject jsonBody = jsonStringToObj(stringBody);
    String method = jsonBody.getString(METHOD);

    System.out.println("Request in HttRpcHandler.handle: " + stringBody);
    String response = switch (method) {
      case GET_SIZE -> handleGetSize(jsonBody);
      case ADD_RECORD -> handleAddRecord(jsonBody);
      case GET_RECORD -> handleGetRecord(jsonBody);
      default -> handleError(jsonBody);
    };

    System.out.println("Response in HttRpcHandler.handle: " + response);
    exchange.sendResponseHeaders(200, response.length());
    OutputStream os = exchange.getResponseBody();
    os.write(response.getBytes());
    os.close();

  }

  private String handleError(JsonObject jsonBody) {

    return Json.createObjectBuilder(jsonBody).addAll(Json.createObjectBuilder(ERROR_JSON)).build()
        .toString();
  }

  private String handleGetRecord(JsonObject jsonBody) {
    int index = jsonBody.getJsonObject(PARAMS).getInt(INDEX);

    return Json.createObjectBuilder(jsonBody).remove(METHOD).remove(PARAMS)
        .add(RESULT, HttpRpcServer.getRecord(index)).build().toString();
  }

  private String handleAddRecord(JsonObject jsonBody) {
    int index = jsonBody.getJsonObject(PARAMS).getInt(INDEX);
    String name = jsonBody.getJsonObject(PARAMS).getString(NAME);
    HttpRpcServer.updateDB(index, name);
    return Json.createObjectBuilder(jsonBody).remove(METHOD).remove(PARAMS)
        .add(RESULT, HttpRpcServer.getRecord(index)).build().toString();
  }

  private String handleGetSize(JsonObject jsonBody) {
    return Json.createObjectBuilder(jsonBody).remove(METHOD).add(RESULT, HttpRpcServer.getSize())
        .build().toString();
  }

}
