package edu.cs3500.spreadsheets.model.values;

import java.util.Objects;

/**
 * Class defines what it is to be a string within a cell.
 */
public class StringValue implements Value {
  private String string;

  /**
   * Constructor. Takes in a string value and saves it.
   * @param string string to be saved as this.string.
   */
  public StringValue(String string) {
    this.string = string;
  }

  @Override
  public String toString() {
    return String.valueOf(string);
  }

  @Override
  public Value evaluate() {
    return null;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof StringValue)) {
      return false;
    }
    StringValue value = (StringValue) o;
    return value.string.equals(string);
  }

  /**
   * Standard get function.
   * @return the value of the boolean.
   */
  public String getValue() {
    return this.string;
  }

  @Override
  public void setValue(Object string) {
    this.string = string.toString();
  }

  @Override
  public int hashCode()  {
    return Objects.hash(string);
  }
  
}

