import static junit.framework.TestCase.assertEquals;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Function;
import org.junit.Test;


/**
 * Testing functionality of functions SUM, PROD, < and COMB.
 */
public class ValueTests {

  @Test
  public void testSUM() {
    Cell test = new Cell(new Coord(1,1), new Function("=(SUM 10 2)"));
    assertEquals(12, test.getContents());
  }

  @Test
  public void testPRODUCT() {
    Cell test = new Cell(new Coord(1,1), new Function("=(PROD 10 2)"));
    assertEquals(20, test.getContents());
  }

  @Test
  public void testLessThan() {
    Cell test = new Cell(new Coord(1,1), new Function("=(< 2 10)"));
    assertEquals(true, test.getContents());
  }

  @Test
  public void testCombine() {
    Cell test = new Cell(new Coord(1,1),
        new Function("=(COMB HELLO DARIN AND SATWIK"));
    assertEquals("HELLODARINANDSATWIK", test.getContents());
  }


}
