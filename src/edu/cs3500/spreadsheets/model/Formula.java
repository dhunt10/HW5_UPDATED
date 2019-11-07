package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.values.Value;

/**
 * This represents any function, reference, or value that goes into a cell.
 */
public interface Formula {

  /**
   * This lets us see what the formula is as a string.
   * @return a String representation of a formula.
   */
  @Override
  public String toString();

  public Value evaluate();

}
