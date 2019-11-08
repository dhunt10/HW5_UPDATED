package edu.cs3500.spreadsheets.model.values;

<<<<<<< HEAD
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.values.Value;
=======
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
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
<<<<<<< HEAD
  public void setValue(String string) {
    this.string = string;
=======
  public void setValue(Object string) {
    this.string = string.toString();
  }

  @Override
  public Value evaluate() {
    return this;
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
  }

  @Override
  public int hashCode()  {
    return Objects.hash(string);
  }
<<<<<<< HEAD

=======
  
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
}

