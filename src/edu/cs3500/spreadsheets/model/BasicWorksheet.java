package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.model.reference.Reference;
import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;

public class BasicWorksheet implements Spreadsheet {

  private ArrayList<ArrayList<Cell>> currSpreadSheet;

  public BasicWorksheet(ArrayList<ArrayList<Cell>>  currSpreadSheet){
    this.currSpreadSheet = currSpreadSheet;
  }
  public static Builder defaultBuilder() {
    return new Builder();
  }


  @Override
  public Cell getCellAt(Coord coord)
  {
     return currSpreadSheet.get(coord.col-1).get(coord.row -1);
  }


  public static final class Builder implements WorksheetBuilder<Spreadsheet> {

    //set to zero to test empty worksheet
    private int height = 0;
    private int width = 0;
    private ArrayList<ArrayList<Cell>> currSpreadSheet = new ArrayList<>();


    public Builder setHeight(int height) {
      if (height < 0) {
        throw new IllegalArgumentException("Height cannot be negative");
      }
      this.height = height;
      return this;
    }

    public Builder setWidth(int width) {
      if (height < 0) {
        throw new IllegalArgumentException("Height cannot be negative");
      }
      this.width = width;
      return this;
    }

    public Builder setGrid() {
      currSpreadSheet = new ArrayList<>();
      return this;
    }

    @Override
    public Builder createCell(int col, int row, String contents) {
      Coord coord = new Coord(col, row);

      if (contents.charAt(0) == '=') {
        if (contents.contains(":")) {
          Sexp sexp = Parser.parse(contents.substring(1));
          Reference ref = new Reference(sexp.toString());
          Cell cell = new Cell(coord, ref);
          currSpreadSheet.get(col - 1).add(row - 1, cell);
          return this;

        } else {
          Sexp sexp = Parser.parse(contents.substring(1));
          Cell cell = new Cell(coord, sexp.accept(new SexpToFormula()));
          currSpreadSheet.get(col - 1).add(row - 1, cell);
          return this;
        }
      } else {
        Cell cell = new Cell(coord, Parser.parse(contents).accept(new SexpToFormula()));
        return this;
      }
    }

    public Builder blankCell(int col, int row) {
      Coord coord = new Coord(col, row);
      Cell cell = new Cell(coord);
      currSpreadSheet.get(col -1).add(row -1, cell);
      return this;
    }


    @Override
    public BasicWorksheet createWorksheet() {
      if (currSpreadSheet.size() == 0 || currSpreadSheet.get(0).size() == 0) {
        throw new IllegalArgumentException("Null width or height");
      }
      return new BasicWorksheet(currSpreadSheet);
    }


  }
}
