package assignment5;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.rmi.Remote;
import java.rmi.server.UnicastRemoteObject;

/**
 * Server
 */
public class Assignment5Server {

  public static final int PORT = 9805;
  public static final String FILENAME = "./out/stub.obj";

  public static void main(String[] args) throws IOException, ClassNotFoundException {
    // initiate a server and publish it to file
    DataBaseAdvancedImpl obj = new DataBaseAdvancedImpl();
    Remote stub = UnicastRemoteObject.exportObject(obj, PORT);
    System.err.println("Server ready");
    writeStubToFile(FILENAME, stub);
  }

  private static void writeStubToFile(String fileName, Remote stub)
      throws FileNotFoundException, IOException {
    FileOutputStream fos = new FileOutputStream(fileName);
    ObjectOutputStream out = new ObjectOutputStream(fos);
    out.writeObject(stub);
    out.close();
  }
}
