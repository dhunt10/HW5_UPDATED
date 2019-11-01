package edu.cs3500.spreadsheets.model.values;

import edu.cs3500.spreadsheets.model.values.Value;
import java.util.Objects;

public class BooleanValue implements Value {

  private boolean bool;

  public BooleanValue(boolean bool){
    this.bool = bool;
  }

  @Override
  public String toString(){
    return String.valueOf(bool);
  }

  @Override
  public boolean equals(Object o){
    if (this == o) {
      return true;
    }
    if (!(o instanceof BooleanValue)) {
      return false;
    }
    BooleanValue value = (BooleanValue) o;
    return Boolean.compare(value.bool, bool)==0;
  }


  public boolean getValue() {
    return this.bool;
  }


  @Override
  public void setValue(String bool) {
      this.bool = Boolean.parseBoolean(bool);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bool);
  }


}
