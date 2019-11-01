package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.model.values.Cell;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;

public class BasicWorksheet implements Spreadsheet {

  private ArrayList<ArrayList<Cell>> currSpreadSheet;


  @Override
  public Cell getCellAt(Coord coord) {
    return null;
  }

  @Override
  public int getHeight() {
    return 0;
  }

  @Override
  public int getWidth() {
    return 0;
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
        Sexp sexp = Parser.parse(contents.substring(1));
        Cell cell = new Cell(coord, sexp.toString());
        cell.setSexp(sexp);
        cell.setFormula(sexp.toString());
        currSpreadSheet[col - 1][row - 1] = cell;
        return this;

      } else {
        Cell cell = new Cell(coord, contents);
        try {
          currSpreadSheet[col - 1][row - 1] = cell;
          cell.setDouble(Double.valueOf(contents));
          return this;
        } catch (NumberFormatException n) {
          currSpreadSheet[col - 1][row - 1] = cell;
          cell.setBoolean(Boolean.valueOf(contents));
          cell.setString(contents);
          return this;
        }
      }
    }

    public Builder blankCell(int col, int row) {
      Coord coord = new Coord(col, row);
      Cell cell = new Cell(coord);
      currSpreadSheet[col-1][row-1] = cell;
      return this;
    }

    @Override
    public BasicWorksheet createWorksheet() {
      if (this.height < 0 || this.width < 0) {
        throw new IllegalArgumentException("Null width or height");
      }
      return new BasicWorksheet(height, width, currSpreadSheet);
    }

  }
}
