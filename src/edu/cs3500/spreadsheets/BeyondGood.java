package edu.cs3500.spreadsheets;

import edu.cs3500.spreadsheets.model.BasicWorksheet;
import edu.cs3500.spreadsheets.model.Spreadsheet;
import edu.cs3500.spreadsheets.model.WorksheetReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * The main class for our program.
 */
public class BeyondGood {
  /**
   * @param args any command-line arguments
   */
  public static void main(String[] args) throws FileNotFoundException {
  File infile = null;
    String incell = null;
    for(int i = 0; i < args.length; i++){
      switch(args[i]){
        case("-in"):
          if(i == args.length -1){
            throw new IllegalArgumentException("You need to give me an input file you dumb-dumb");
          }
            infile = new File(args[i+1]);
            i++;
            break;
        case("-eval"):
          if(i == args.length -1){
            throw new IllegalArgumentException("You need to give me a cell you silly nugget");
          }
          incell = args[i+1];
          i++;
          break;
        default:
          throw new IllegalArgumentException("This is not how you use our application tough guy");
      }
    }
    if(infile == null || incell == null){
      throw new IllegalArgumentException("bro give us some inputs to work with");
    }
    createSpreadSheet(infile, incell);
  }

  private static void createSpreadSheet(File file, String cell) throws FileNotFoundException {
    FileReader fileReader = new FileReader(file);
    Spreadsheet s = WorksheetReader.read(BasicWorksheet.defaultBuilder(), fileReader);
  }
}
