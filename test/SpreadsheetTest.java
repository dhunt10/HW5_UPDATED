import edu.cs3500.spreadsheets.model.BasicWorkSheet;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import org.junit.Test;

public class SpreadsheetTest {


  @Test
  public void testEmptySheet(){

    Spreadsheet s = BasicWorksheet.defaultBuilder().createWorksheet();
    assertEquals(0, s.ge);
    assertEquals(0, s.getHeight());
  }

  @Test
  public void addCells(){

  }
}
