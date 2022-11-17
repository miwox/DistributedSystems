package assignment4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BufferServer implements Runnable {

  private final int port;


  public BufferServer(int port) {
    this.port = port;
  }

  @Override
  public void run() {
    try {
      ServerSocket serverSocket = new ServerSocket(port);
      System.out.println("Server started.. listening on Port: " + serverSocket.getLocalPort());

      while (true) {
        Socket socket = serverSocket.accept();
        System.out.println("Incoming connection....");
        new Thread(new BufferConnectionHandler((socket))).start();
      }
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}
