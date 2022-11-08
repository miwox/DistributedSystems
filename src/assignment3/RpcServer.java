package assignment3;

import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;

public class RpcServer {

    HttpServer httpServer;


    public RpcServer(String inet, int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/", new RpcHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        RpcServer rpc = new RpcServer("sdjsd", 34);
        new RpcClient();
    }

}
