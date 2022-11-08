package assignment2.assigment1;
import java.io.IOException;
public class Assignment1b {

    public static final String HTTPS_STUD_FH_WEDEL_DE = "https://stud.fh-wedel.de/";

    //client with URL class
    public static void main(String[] args) throws IOException {
        ClientUrlHttp client = new ClientUrlHttp(HTTPS_STUD_FH_WEDEL_DE);
        client.setRequestMode("GET");
        client.getResponse().forEach(System.out::println);

        //not working everytime
        //Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("192.0.2.100", 80));
        //client = new ClientUrlHttp(HTTPS_STUD_FH_WEDEL_DE, proxy);
        //client.getResponse().forEach(System.out::println);
    }
}
