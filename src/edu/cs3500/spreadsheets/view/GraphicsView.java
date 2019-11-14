package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.util.Map;

/**
 * This represents a graphical view that will call on our JFrame class.
 */
public class GraphicsView implements IView{
  GraphicsFrame frame;
  Map<Coord, Cell> sheet;
  int width;
  int height;
  int x;
  int y;

  /**
   * This is the constructor.
   * @param sheet cells to be used in our view.
   * @param width how wide the frame will be in # of cells, not necessarily in the starting window.
   * @param height how tall the fame will be in # of cells, not necessarily in the starting window.
   */
  public GraphicsView(Map<Coord, Cell> sheet, int width, int height) {
    this.sheet = sheet;
    this.width = width;
    this.height = height;
    this.frame = new GraphicsFrame(sheet, width, height);
  }


  /**
   * Inherited from interface, not needed in a graphical view.
   * @param filePath filepath to save the file to.
   */
  @Override
  public void saveTo(String filePath) {
    throw new UnsupportedOperationException("Can't save a visual view");
  }

  /**
   * Calls method from frame to turn visibility on.
   */
  @Override
  public void display() {
    frame.display();
  }

  /**
   * This is inherited from the interface, not needed in a graphical view, throw error.
   * @return
   */
  @Override
  public String buildTextView() {
    throw new UnsupportedOperationException(
        "Can't display textual view of visual view");
  }
}
