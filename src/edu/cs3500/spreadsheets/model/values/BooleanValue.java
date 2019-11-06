package edu.cs3500.spreadsheets.model.values;

import java.util.Objects;

/**
 * Class defines what it is to be a boolean value within a cell.
 */
public class BooleanValue implements Value {

  private boolean bool;


  /**
   * Constructor. takes in a boolean and saves it.
   * @param bool boolean to be saved as this.boolean.
   */
  public BooleanValue(boolean bool) {
    this.bool = bool;
  }

  @Override
  public String toString() {
    return String.valueOf(bool);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BooleanValue)) {
      return false;
    }
    BooleanValue value = (BooleanValue) o;
    return Boolean.compare(value.bool, bool) == 0;
  }


  /**
   * Standard get function.
   * @return the value of the boolean.
   */
  public boolean getValue() {
    return this.bool;
  }


  @Override
  public int hashCode() {
    return Objects.hash(bool);
  }

  @Override
  public Value evaluate() {
    return this;
  }

  @Override
  public void setValue(Object value) {

  }
}

