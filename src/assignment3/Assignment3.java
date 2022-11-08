package assignment3;

import java.io.IOException;
import javax.json.Json;
import javax.json.JsonObject;



public class Assignment3 {

  public static void main(String[] args) throws IOException, InterruptedException {

    HttpRpcServer rpc = new HttpRpcServer();
    HttpRpcClientComponent.requestSize();
    HttpRpcClientComponent.getRecord(0);
    HttpRpcClientComponent.updateRecord(45, "Julia");
    JsonObject value = Json.createObjectBuilder()
        .add("firstName", "John")
        .add("lastName", "Smith")
        .add("age", 25)
        .add("address", Json.createObjectBuilder()
            .add("streetAddress", "21 2nd Street")
            .add("city", "New York")
            .add("state", "NY")
            .add("postalCode", "10021"))
        .add("phoneNumber", Json.createArrayBuilder()
            .add(Json.createObjectBuilder()
                .add("type", "home")
                .add("number", "212 555-1234"))
            .add(Json.createObjectBuilder()
                .add("type", "fax")
                .add("number", "646 555-4567")))
        .build();


  }
}

