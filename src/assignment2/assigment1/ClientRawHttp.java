package assignment2.assigment1;

import java.io.*;
import java.net.Socket;
import java.util.List;

public class ClientRawHttp {

    private static final String CRLF = "\r\n";
    private final Socket socket;
    private final PrintWriter writer;
    private final BufferedReader reader;

    public ClientRawHttp(String host, int port) throws IOException {
        this.socket = new Socket(host, port);
        writer = new PrintWriter(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    /**
     * Writes line HTTP-conform
     * each line has to be seperated with CRLF see HTTP-RFC!
     * This is important to work on different OS
     * @param text
     */
    public void writeLine(String text){
        writer.print(text + CRLF);
    }
    public void transmitText(){
        writer.flush();
    }

    public List<String> getResponse(){
        return reader.lines().toList();
    }

    public void close() throws IOException {
        writer.close();
        reader.close();
        socket.close();

    }
}
