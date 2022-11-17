package assignment4;

import assignment4.LogMessage.Message;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class BufferClientComponent {

  public static void buildClientToSendProtocolMessage(InetAddress host, int port, Message message)
      throws IOException {
    Socket socket = new Socket(host,8000);
    OutputStream os = socket.getOutputStream();
    message.writeTo(os);
    os.flush();
    os.close();
  }
}


