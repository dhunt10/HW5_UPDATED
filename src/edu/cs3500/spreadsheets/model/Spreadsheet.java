
package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import java.util.List;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.values.Value;

public interface Spreadsheet {

  public Cell getCellAt(int x, int y);
  public int getHeight();
  public int getWidth();

  Cell getCellAt(Coord coord);

  int getHeight();

  int getWidth();

  int setCell(Coord coord, String item);

  Value getEvaluated(Coord coord);
}