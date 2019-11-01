package edu.cs3500.spreadsheets.model.values;

import java.util.Objects;

public class NumValue implements Value {

  private double number;

  public NumValue(double number){
    this.number = number;
  }

  @Override
  public String toString(){
     return String.valueOf(number);
  }


  @Override
  public boolean equals(Object o){
    if (this == o) {
      return true;
    }
    if (!(o instanceof NumValue)) {
      return false;
    }
    NumValue value = (NumValue) o;
    return Double.compare(value.number, number) == 0;
  }

  public double getValue() {
    return this.number;
  }

  public void setValue(double number) {
      this.number = number;
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public void setValue(String value) {

  }
}
