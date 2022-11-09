package assignment3;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

public class JsonFactory {

  public static final String GET_SIZE = "getSize";
  public static final String ADD_RECORD = "addRecord";
  public static final String METHOD = "method";
  public static final String GET_RECORD = "getRecord";
  public static final String RESULT = "result";
  public static final String INDEX = "index";
  public static final String NAME = "name";
  public static final String PARAMS = "params";
  public static final JsonObject ERROR_JSON = Json.createObjectBuilder()
      .add("Error", Json.createObjectBuilder().add("message", "Parse Error").build()).build();


  public static JsonObject jsonStringToObj(String jsonString) {
    JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
    JsonObject object = jsonReader.readObject();
    jsonReader.close();
    return object;
  }

  public static JsonObjectBuilder buildRpcJson() {
    return Json.createObjectBuilder().add("jsonrpc", "2.0");
  }

}
