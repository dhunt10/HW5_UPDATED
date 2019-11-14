import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.view.TextView;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TextViewTest {

  Map<Coord, Cell> sheet = new HashMap<>();
  TextView tv;


  @Test
  public void testEmpty() {
    tv = new TextView(sheet);
    assertEquals("", tv.buildTextView());
  }

  @Test
  public void testnotEmpty() {
    sheet.put(new Coord(1, 1), new Cell(new Coord(1, 1), new StringValue("test"), "nothing"));
    tv = new TextView(sheet);
    assertEquals("A1 \n", tv.buildTextView());
  }

  @Test
  public void testLongInput() {
    Cell c1 = new Cell(new Coord(1  ,1));
    Cell c2 = new Cell(new Coord(2 ,1));
    c1.setEvaluatedData(new StringValue("Darin eats ass"));
    c2.setEvaluatedData(new BooleanValue(false));
    sheet.put(new Coord(1,1), c1);
    sheet.put(new Coord(1,2), c2);
    tv = new TextView(sheet);
    assertEquals("A2 false\n"
        + "A1 Darin eats ass\n", tv.buildTextView());
  }

}
