package assignment5;

import static assignment5.Assignment5Server.FILENAME;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Assigment5Client {

  public static void main(String[] args) throws IOException, ClassNotFoundException {

    // initiate a client and reading the file
    DatabaseAdvanced client = readStubFromFile(FILENAME);
    // put something in the database
    client.addRecord(1, "Miwand");
    client.addRecord(2, "Gianluca");
    client.addRecord(3, "Richard");
    client.addRecord(4, "Prof. Hoffmann");
    client.addRecord(5, "Miwand");
    //should be 4
    System.out.println(client.getSize());
    System.out.println(client.getIndex("Miwand"));

    System.out.println(client.getRecordObj(4).getKey());
    System.out.println(client.getRecordObj(4).getValue());
    DBResult result = client.getRecordObj(4);
    result.setValue("sdsd");
  }

  private static DatabaseAdvanced readStubFromFile(String fileName)
      throws FileNotFoundException, IOException, ClassNotFoundException {
    FileInputStream fis = new FileInputStream(fileName);
    ObjectInputStream in = new ObjectInputStream(fis);
    DatabaseAdvanced remoteObj = (DatabaseAdvanced) in.readObject();
    in.close();
    return remoteObj;
  }

}
