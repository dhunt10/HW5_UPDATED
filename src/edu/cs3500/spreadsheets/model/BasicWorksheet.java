package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import javax.swing.plaf.IconUIResource;
>>>>>>> Stashed changes


public class BasicWorkSheet implements Spreadsheet {

  final int height;
  final int width;
<<<<<<< Updated upstream
  private final Cell[][] currSpreadSheet;

  public BasicWorkSheet(int height, int width, Cell[][] worksheet) {
    this.height = height;
    this.width = width;
    currSpreadSheet = worksheet;
  }

  public int getHeight(){
    return this.height;
  }

  public int getWidth(){
    return this.width;
  }

  public static Builder defaultBuilder() {
    return new Builder();
=======

  public BasicWorksheet() {

  }

  @Override
  public Cell getCellAt(Coord coord) {
    return currSpreadSheet.get(coord.col).get(coord.row);
  }

  @Override
  public int getHeight() {
    return ;
>>>>>>> Stashed changes
  }

  @Override
  public Cell getCellAt(int x, int y) {
    return currSpreadSheet[x-1][y-1];
  }

  public Cell getCellAt(Coord coord) {
    return null;
  }


  public static final class Builder implements WorksheetBuilder<Spreadsheet> {

    //set to zero to test empty worksheet
    private int height = 0;
    private int width = 0;
    private Cell[][] currSpreadSheet = new Cell[height][width];

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
      currSpreadSheet = new Cell[width][height];
      return this;
    }

    @Override
    public Builder createCell(int col, int row, String contents) {
      Coord coord = new Coord(col, row);

      if (contents.charAt(0) == '=') {
        Sexp sexp = Parser.parse(contents.substring(1));
        Cell cell = new Cell(coord, sexp.toString());
        cell.setSexp(sexp);
        currSpreadSheet[col - 1][row - 1] = cell;
        return this;
      } else {
        try {
          Cell cell = new Cell(coord, contents);
          currSpreadSheet[col - 1][row - 1] = cell;
          cell.setBoolean(Boolean.valueOf(contents));
          return this;
        } catch (NullPointerException e) {
          try {
            Cell cell = new Cell(coord, contents);
            currSpreadSheet[col - 1][row - 1] = cell;
            cell.setDouble(Double.valueOf(contents));
            return this;
          } catch (NullPointerException ee) {
            Cell cell = new Cell(coord, contents);
            currSpreadSheet[col - 1][row - 1] = cell;
            cell.setString(contents);
            return this;
          }
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
    public BasicWorkSheet createWorksheet() {
      if (this.height < 0 || this.width < 0) {
        throw new IllegalArgumentException("Null width or height");
      }
      return new BasicWorkSheet(height, width, currSpreadSheet);
    }

  }

}