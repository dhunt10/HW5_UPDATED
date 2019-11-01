
package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import java.util.List;

public interface Spreadsheet {

  public Cell getCellAt(int x, int y);
  public int getHeight();
  public int getWidth();

}