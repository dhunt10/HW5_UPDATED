package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicWorksheet;
import edu.cs3500.spreadsheets.model.BasicWorksheet.Builder;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import edu.cs3500.spreadsheets.view.ButtonGrid;
import edu.cs3500.spreadsheets.view.GraphicsView;
import edu.cs3500.spreadsheets.view.IView;
import edu.cs3500.spreadsheets.view.TextView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

/**
 * The main class for our program.
 */
public class BeyondGood {
  /**
   * Static void main.
   * @param args any command-line arguments.
   */
  public static void main(String[] args) throws FileNotFoundException {
    File infile = new File(
        "/Users/darinhunt/Desktop/OOD/HW55555/HW5_UPDATED/test/test4.txt");
    File outfile = new File(
        "/Users/darinhunt/Desktop/OOD/HW55555/HW5_UPDATED/test/testresult.txt");
    String incell = null;
    String view = "graphic";
    for (int i = 0; i < args.length; i++) {
      switch (args[i]) {
        case("-in"):
          if (i == args.length - 1) {
            throw new IllegalArgumentException("You need to give me an input file you dumb-dumb");
          }
          infile = new File(args[i + 1]);
          i++;
          break;
        case("-eval"):
          if (i == args.length - 1) {
            throw new IllegalArgumentException("You need to give me a cell you silly nugget");
          }
          incell = args[i + 1];
          i++;
          break;
        case("-save"):
          if(i == args.length - 1){
            throw new IllegalArgumentException("Need a file name to save to");
          }
          outfile = new File(args[i+1]);
          view = "text";
          i++;
          break;
        case("-gui"):
          view = "graphic";
          break;
        default:
          throw new IllegalArgumentException("This is not how you use our application tough guy");
      }
    }
    if (infile == null && incell == null) {
      throw new IllegalArgumentException("bro give us some inputs to work with");
    }

    createSpreadSheet(infile, incell, view, outfile);
  }

    /**
   * Function that creates a spreadsheet by taking in a file.
   * @param file the name of the file.
   * @param cell cell.
   * @throws FileNotFoundException
   */
  private static void createSpreadSheet(File file,
      String cell, String type, File saveTo) throws FileNotFoundException {
    Builder b = new Builder();
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader(file));
      String line = reader.readLine();
      while (line != null) {
        String[] phrase = line.split(" ", 2);
        String coordinate = phrase[0];
        String formula = phrase[1];
        int col = Coord.colNameToIndex(String.valueOf(coordinate.charAt(0)));
        int row = Integer.parseInt(String.valueOf(coordinate.charAt(1)));
        b.createCell(col, row, formula);
        line = reader.readLine();
      }
      reader.close();
    }
    catch (IOException e) {
      throw new IllegalArgumentException(e);
    }
    FileReader fileReader = new FileReader(file);
    Spreadsheet s = WorksheetReader.read(BasicWorksheet.defaultBuilder(), fileReader);
    Map<Coord, Cell> board = s.getCurrSpreadSheet();

    b.createWorksheet();

    IView v = createView(type, saveTo, s);
    v.display();
  }

  public static IView createView(String type, File saveTo, Spreadsheet s) {
    switch (type) {
      case("text"):
        TextView createView = new TextView(s.getCurrSpreadSheet());
        createView.saveTo(saveTo.getPath());
        return createView;
      case("graphic"): return new GraphicsView(s.getCurrSpreadSheet(),  50, 50);
      default: throw new IllegalArgumentException("This type of view is not supported");
    }
  }
}
