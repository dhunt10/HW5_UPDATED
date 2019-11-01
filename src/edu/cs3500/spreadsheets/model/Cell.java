package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.reference.Reference;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import java.util.List;

/**
 * Defines what a cell is and how it is defined.
 */
public class Cell {

  private Formula contents;
  private Coord coords;
  private Value evaluatedData;

  /**
   * Construtor for a cell that will have contents.
   * @param coords the coordinates of the cell in currSpreadSheet.
   * @param contents content of the cell, not yet evaluated.
   */
  public Cell(Coord coords, Formula contents) {
    this.coords = coords;
    this.contents = contents;
  }

  /**
   * Construtor for a cell that will be blank.
   * @param coords the coordinates of the cell in currSpreadSheet.
   */
  public Cell(Coord coords) {
    this.coords = coords;
    this.contents = new StringValue("");
  }

  /**
   * Evaluates the cell depending on what kind of formula is encased to it.
   * @param coord the coordinates of the cell you wish to evaluate.
   * @return returns the final value of the cell (Can be number, string or boolean)
   */
  public Value getEvaluated(Coord coord) {
    try {
      Reference ref = (Reference) contents;
      contents = ref;
    }
    catch (IllegalArgumentException e) {

    }
    try {
      Value value = (Value) contents;
      contents = value;
    }
    catch (IllegalArgumentException e) {

    }
    try {
      Function func = (Function) contents;
      contents = func;
    }
    catch (IllegalArgumentException e) {

    }
    return evaluatedData;
  }

  /**
   * Returns the contents of the cell.
   * @return contents of the cell.
   */
  public Formula getContents() {
    return this.contents;
  }

  /**
   * Changes the current content of the cell.
   * @param contents the newly inputted content.
   */
  public void setContents(Formula contents) {
    this.contents = contents;
  }

}

