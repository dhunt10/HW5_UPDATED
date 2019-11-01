package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.values.Cell;

public interface Spreadsheet {
  public Cell getCellAt(Coord coord);
  public int getHeight();
  public int getWidth();

}
