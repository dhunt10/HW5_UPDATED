import edu.cs3500.spreadsheets.model.BasicWorksheet;
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
    Spreadsheet s = BasicWorksheet.defaultBuilder().createWorksheet();
    Spreadsheet a = BasicWorksheet.defaultBuilder().createCell(1,1,"Hello").Build;

  }
}
