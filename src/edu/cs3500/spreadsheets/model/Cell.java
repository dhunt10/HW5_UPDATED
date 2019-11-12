package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.SList;
import java.awt.Graphics2D;


/**
 * Defines what a cell is and how it is defined.
 */
public class Cell {

  private Formula contents;
  private Coord coord;
  private Value evaluatedData;

  /**
   * Construtor for a cell that will have contents.
   * @param coords the coordinates of the cell in currSpreadSheet.
   * @param contents content of the cell, not yet evaluated.
   */
  public Cell(Coord coords, Formula contents) {
    this.coord = coords;
    this.contents = contents;
  }

  /**
   * Construtor for a cell that will be blank.
   * @param coord the coordinates of the cell in currSpreadSheet.
   */
  public Cell(Coord coord) {
    this.coord = coord;
    this.contents = new StringValue("");
    this.evaluatedData = new StringValue("");
  }

  /**
   * Returns the raw contents of the cell.
   * @return raw contents of the cell.
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

  /**
   * Gets data that has been evaluated.
   * @return data that has been evaluated.
   */
  public String getEvaluatedData() {
    return this.evaluatedData.toString();
  }

  /**
   * Setter to set the final evaluated data to appear to user.
   * @param value value to be set as the evaluated value.
   */
  public void setEvaluatedData(Value value) {
    this.evaluatedData = value;
  }

  public void drawSelf(Graphics2D g2d) {
    g2d.drawRect(coord.col, coord.row, 20, 10);
    g2d.drawString(this.toString(), coord.col, coord.row);
  }

  @Override
  public String toString() {
    return evaluatedData.toString();
  }

}

