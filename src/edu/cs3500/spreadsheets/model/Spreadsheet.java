
package edu.cs3500.spreadsheets.model;

<<<<<<< HEAD
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
=======
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
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
