package assignment4;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BufferConnectionHandler implements Runnable {
  private final Socket socket;

  public BufferConnectionHandler(Socket socket) {
    this.socket = socket;
  }

  @Override
  public void run() {
    System.out.println("Ich bin der Handler");
    try {
      InputStream is = socket.getInputStream();
      copyInputStreamToFile(is, "./out/text.txt");
      is.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  public static void copyInputStreamToFile(InputStream input, String file) {

    try (OutputStream output = new FileOutputStream(file, true)) {
      input.transferTo(output);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }
}
