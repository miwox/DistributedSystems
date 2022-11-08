package assignment2.assigment1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;

public class ClientUrlHttp {
    private final HttpURLConnection con;

    public ClientUrlHttp(String url) throws IOException {
        con = (HttpURLConnection) new URL(url).openConnection();
    }

    public ClientUrlHttp(String url, Proxy proxy) throws IOException {
        con = (HttpURLConnection) new URL(url).openConnection(proxy);
    }

    public void setRequestMode(String mode) throws ProtocolException {
        con.setRequestMethod(mode);
    }

    public List<String> getResponse() throws IOException {
        return new BufferedReader(new InputStreamReader(con.getInputStream())).lines().toList();
    }


}
