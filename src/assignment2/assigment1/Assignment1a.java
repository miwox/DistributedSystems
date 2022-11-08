package assignment2.assigment1;
import java.io.IOException;


public class Assignment1a {

    public static final String STUD_FH_WEDEL_DE = "stud.fh-wedel.de";

    //client raw sending http request
    public static void main(String[] args) throws IOException {
        ClientRawHttp client = new ClientRawHttp(STUD_FH_WEDEL_DE, 80);
        client.writeLine("GET / HTTP/1.1");
        client.writeLine("Host: stud.fh-wedel.de");
        //empty line is important to fulfill http-protocol
        client.writeLine("");
        client.transmitText();
        client.getResponse().forEach(System.out::println);
        client.close();


    }
}
