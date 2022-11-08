package assignment2.assignment2;

import assignment2.assigment1.ClientRawHttp;

import java.io.IOException;

import static assignment2.assignment2.Assignment2a.PORT;

public class Assignment2b {
    public static void main(String[] args) throws IOException {
        HttpServer server = new HttpServer(PORT);
        new Thread(server).start();
        ClientRawHttp client = new ClientRawHttp("127.0.0.1", 4444);
        client.writeLine("Was Geht Bro");
        client.transmitText();
        client.getResponse().forEach(System.out::println);
        client.close();
    }
}
