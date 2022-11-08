package assignment2.assignment2;

import java.io.*;
import java.net.Socket;
import java.util.StringTokenizer;

public class HttpRequestHandler implements Runnable {

    private static final String CRLF = "\r\n";

    public HttpRequestHandler(Socket socket) throws IOException {
        br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        output = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
    }

    private final BufferedReader br;
    private final BufferedWriter output;


    /**
     * Is writing all GET requests bodies in stream
     */
    @Override
    public void run() {
        while (true) {
            try {
                String headerLine = br.readLine();
                if (headerLine.equals(CRLF) || headerLine.equals(""))
                    break;
                System.out.println(headerLine);
                StringTokenizer s = new StringTokenizer(headerLine);
                String temp = s.nextToken();
                if(temp.equals("GET")){
                    //write something funny
                    output.write("Hallo Welt");

                    output.flush();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
