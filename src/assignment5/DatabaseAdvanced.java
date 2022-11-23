package assignment5;

import java.rmi.RemoteException;
import java.util.Set;


public interface DatabaseAdvanced extends Database {

  /**
   * @param record record
   * @return the can be multiple entries in the database so return a set
   * @throws RemoteException very important otherwise exeption!
   */
  Set<Integer> getIndex(String record) throws RemoteException;

  DBResult getRecordObj(int index) throws RemoteException;
}
