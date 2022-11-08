package assignment3;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class HttpRpcServer {

  private static final Map<String, String> database = new HashMap<>();

  public HttpRpcServer() throws IOException {
    HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
    server.createContext("/", new HttpRpcHandler());
    server.setExecutor(null); // creates a default executor
    server.start();
  }

  public static int getSize() {
    return database.size();
  }

}
