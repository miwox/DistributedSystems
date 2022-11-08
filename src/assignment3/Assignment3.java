package assignment3;

import java.io.IOException;
import javax.json.JsonObject;



public class Assignment3 {

  public static void main(String[] args) throws IOException, InterruptedException {

    HttpRpcServer rpc = new HttpRpcServer();
    HttpRpcClientComponent.requestSize();
    HttpRpcClientComponent.getRecord(0);
  }
}

