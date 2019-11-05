package edu.cs3500.spreadsheets.model.values;

import edu.cs3500.spreadsheets.model.Formula;

/**
 * Formula.
 */
public interface Value extends Formula {
  void setValue(Object value);
}
