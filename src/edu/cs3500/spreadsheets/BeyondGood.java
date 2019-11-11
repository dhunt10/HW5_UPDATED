package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicWorksheet;
import edu.cs3500.spreadsheets.model.BasicWorksheet.Builder;
import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
    File infile = null;
    String incell = null;
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
        default:
          throw new IllegalArgumentException("This is not how you use our application tough guy");
      }
    }
    if (infile == null || incell == null) {
      throw new IllegalArgumentException("bro give us some inputs to work with");
    }
    createSpreadSheet(infile, incell);
  }

  private static void createSpreadSheet(File file, String cell) throws FileNotFoundException {
    Builder b = new Builder();
    BufferedReader reader;
    try {
      reader = new BufferedReader(new FileReader("filename.txt"));
      String line = reader.readLine();
      while (line != null) {
        line = reader.readLine();
        String[] phrase = line.split(" ", 2);
        String coordinate = phrase[0];
        String formula = phrase[1];
        int col = Coord.colNameToIndex(String.valueOf(coordinate.charAt(0)));
        int row = Integer.parseInt(String.valueOf(coordinate.charAt(1)));
        b.createCell(col, row, formula);
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
    }
}
