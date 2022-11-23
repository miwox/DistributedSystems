package assignment5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Database extends Remote {

  String getRecord(int index) throws RemoteException;

  void addRecord(int index, String record) throws RemoteException;

  int getSize() throws RemoteException;

}
