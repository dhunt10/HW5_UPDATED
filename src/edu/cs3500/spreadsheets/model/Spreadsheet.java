package edu.cs3500.spreadsheets.model;

import java.util.ArrayList;
import java.util.Map;

/**
 * This interface is for all types of worksheets, which are made up of cells.
 */
public interface Spreadsheet {

  /**
   * This helps us get each cell in the worksheet based on their coordinate.
   * @param coord is the location of the cell.
   * @return the cell at the specified coordinate.
   */
  public Cell getCellAt(Coord coord);
  Map<Coord, Cell> getCurrSpreadSheet();
}
