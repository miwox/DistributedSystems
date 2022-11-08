package assignment2.assignment2;
import java.io.IOException;

public class Assignment2a {

    public static final int PORT = 4444;
    public static void main(String[] args) throws IOException {
        //To communicate: http://127.0.0.1:4444 for browser and telnet
        HttpServer server = new HttpServer(PORT);
        server.run();
    }
}
