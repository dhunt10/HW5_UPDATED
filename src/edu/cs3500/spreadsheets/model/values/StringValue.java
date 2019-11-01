package edu.cs3500.spreadsheets.model.values;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.values.Value;
import java.util.Objects;

public class StringValue implements Value {
  private String string;

  public StringValue(String string){
    this.string = string;
  }

  @Override
  public String toString(){
    return String.valueOf(string);
  }


  @Override
  public boolean equals(Object o){
    if (this == o) {
      return true;
    }
    if (!(o instanceof StringValue)) {
      return false;
    }
    StringValue value = (StringValue) o;
    return value.string.equals(string);
  }

  public String getValue() {
    return this.string;
  }

  @Override
  public void setValue(String string) {
    this.string = string;
  }

  @Override
  public int hashCode() {
    return Objects.hash(string);
  }
  
}

