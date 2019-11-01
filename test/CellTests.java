import static junit.framework.TestCase.assertEquals;

import com.sun.jdi.DoubleValue;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.NumValue;
import edu.cs3500.spreadsheets.model.values.StringValue;
import org.junit.Test;

public class CellTests {

  @Test
  public void testBoolean(){
    Cell test = new Cell(new Coord(1, 1), new BooleanValue(false));
    assertEquals("false", test.getContents().toString());
  }

  @Test
  public void testString(){
    Cell test = new Cell(new Coord(1, 1), new StringValue("helloworld"));
    assertEquals("helloworld", test.getContents().toString());
  }

  @Test
  public void testDouble(){
    Cell test = new Cell(new Coord(1, 1), new NumValue(46.9));
    assertEquals("46.9", test.getContents().toString());
  }

  @Test
  public void testBlank(){
    Cell test = new Cell(new Coord(1, 1));
    assertEquals("", test.getContents().toString());
  }

  @Test
  public void testFormula(){

  }

}
