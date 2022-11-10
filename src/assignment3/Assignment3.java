package assignment3;

import java.io.IOException;


public class Assignment3 {

  public static void main(String[] args) throws IOException, InterruptedException {

    HttpRpcServer rpc = new HttpRpcServer();

    HttpRpcClientComponent.addRecord(1, "Wedel");
    HttpRpcClientComponent.addRecord(2, "Hamburg");
    HttpRpcClientComponent.addRecord(3, "Stuttgart");
    HttpRpcClientComponent.addRecord(4, "Bayern");
    HttpRpcClientComponent.addRecord(5, "Muenchen");
    HttpRpcClientComponent.addRecord(6, "Muenchen");
    HttpRpcClientComponent.getRecord(6);
    HttpRpcClientComponent.getSize();
  }
}

