package assignment4;

import assignment4.LogMessage.Message;
import assignment4.LogMessage.Message.SecurityLevel;
import com.google.protobuf.Timestamp;
import java.io.IOException;
import java.net.InetAddress;


public class Assignment4 {

  public static final int PORT = 8000;

  public static void main(String[] args) throws IOException, InterruptedException {
    new Thread(new BufferServer(PORT)).start();


    Message message = Message.newBuilder().setTime(Timestamp.newBuilder().build())
        .setType(SecurityLevel.INFO).setCreator("Miwand").setBody("Erde an Mars").build();

    BufferClientComponent.buildClientToSendProtocolMessage(InetAddress.getLocalHost(), PORT, message);

  }
}

