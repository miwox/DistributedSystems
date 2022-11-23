package assignment5;

import java.io.Serializable;

public class DBResult implements Serializable {

  private String value;
  private int key;

  public int getKey() {
    return key;
  }

  public DBResult setKey(int key) {
    this.key = key;
    return  this;
  }

  public String getValue() {
    return value;
  }

  public DBResult setValue(String value) {
    this.value = value;
    return  this;
  }
}
