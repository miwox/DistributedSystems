package assignment3;

import java.io.IOException;



public class Assignment3 {

  public static void main(String[] args) throws IOException, InterruptedException {

    HttpRpcServer rpc = new HttpRpcServer();
    HttpRpcClientComponent.updateRecord(45, "Julia");
  }
}

