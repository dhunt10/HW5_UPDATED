/*import edu.cs3500.spreadsheets.model.BasicWorkSheet;
import static junit.framework.TestCase.assertEquals;

import edu.cs3500.spreadsheets.model.BasicWorksheet;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import org.junit.Test;

/**
 * test functionality of spreadsheet.
 *//*
public class SpreadsheetTest {


  @Test
  public void testEmptySheet() {

    Spreadsheet s = BasicWorksheet.defaultBuilder().createWorksheet();
    assertEquals(true, s == null);

  }

  @Test
  public void addCells() {
    Spreadsheet s = BasicWorksheet.defaultBuilder().createWorksheet();
    Spreadsheet a
        = BasicWorksheet.defaultBuilder().createCell(1,1,"He").createWorksheet();
    Coord coord = new Coord(1,1);
    assertEquals(s.getCellAt(coord).getContents().toString(), "He");
  }
}
*/