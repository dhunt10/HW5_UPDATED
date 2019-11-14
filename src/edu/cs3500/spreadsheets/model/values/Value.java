package edu.cs3500.spreadsheets.model.values;

import edu.cs3500.spreadsheets.model.Formula;

/**
 * Formula.
 */
public interface Value extends Formula {

  /**
   * Setter to set the value of a value object.
   * @param value value to be set.
   */
  void setValue(Object value);

  Value evaluate();
}
