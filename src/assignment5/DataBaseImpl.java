package assignment5;

import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class DataBaseImpl implements DatabaseAdvanced {

  private final Map<Integer, String> database;

  public DataBaseImpl() {
    database = new HashMap<>();
  }


  @Override
  public String getRecord(int index) throws RemoteException {
    return database.get(index);
  }

  @Override
  public void addRecord(int index, String record) throws RemoteException {
    database.put(index, record);
  }

  @Override
  public int getSize() throws RemoteException {
    return database.size();
  }

  @Override
  public Set<Integer> getIndex(String record) {
    return database.entrySet().stream().filter(entry -> Objects.equals(entry.getValue(), record))
        .map(Map.Entry::getKey).collect(Collectors.toSet());
  }

  @Override
  public DBResult getRecordObj(int index) throws RemoteException {
    String value = getRecord(index);
    return value == null ? null : new DBResult().setValue(value).setKey(index);
  }
}
