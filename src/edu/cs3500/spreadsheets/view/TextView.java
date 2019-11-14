package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * This represents a textual view of our spreadsheet.
 */
public class TextView implements IView {
  Map<Coord, Cell> sheet;

  /**
   * This is our constructor, creates the textual view inputs.
   * @param sheet the cells needed to be in our textualview.
   */
  public TextView( Map<Coord, Cell> sheet) {
    this.sheet = sheet;
  }


  /**
   * This is the saveTo inherited from the interface, and it saves the new evaluated textfile
   * to a given output file.
   * @param filePath the path of the file to save the evaluated spreadsheet to.
   */
  @Override
  public void saveTo(String filePath) {
    try {
      PrintWriter out = new PrintWriter(filePath);
      out.print(buildTextView());
      out.close();
    }
    catch (FileNotFoundException f) {
      throw new IllegalArgumentException("Invalid file");
    }
  }

  /**
   * Inherited method from interface, displays the evaluated text on the console.
   */
  @Override
  public void display() {
    System.out.println(buildTextView());
  }

  /**
   * This build the textView by using a String builder to add each cell and its
   * evaluation.
   */
  @Override
  public String buildTextView() {
    StringBuilder output = new StringBuilder();
    String lineSeparator = System.getProperty("line.separator");
    for (Coord c: sheet.keySet()) {
      output.append( c.toString() + " " + sheet.get(c).toString() + lineSeparator);
    }
    return output.toString();
  }


}
