package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Map;

public class TextView implements IView {
  Map<Coord, Cell> sheet;

  public TextView( Map<Coord, Cell> sheet) {
    this.sheet = sheet;
  }


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

  @Override
  public void display() {
    System.out.println(buildTextView());
  }

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
