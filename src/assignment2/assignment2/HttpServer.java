package assignment2.assignment2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer implements Runnable {

    private final ServerSocket serverSocket;

    public HttpServer(int port) throws IOException {
        this.serverSocket = new ServerSocket(port);
        System.out.println("httpServer running on port " + serverSocket.getLocalPort());
    }

    public void run() {
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New connection accepted " + socket.getInetAddress() + ":" + socket.getPort());
                HttpRequestHandler request = new HttpRequestHandler(socket);
                Thread thread = new Thread(request);
                thread.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
