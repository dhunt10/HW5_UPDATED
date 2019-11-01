package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.model.reference.Reference;
import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;

/**
 * This is a worksheet representation that has the basic needs that were
 * in the specifications of the assignment. We made it basic just in case
 * that we are given different types of worksheets later on.
 */
public class BasicWorksheet implements Spreadsheet {

  private ArrayList<ArrayList<Cell>> currSpreadSheet;

  /**
   * This build the worksheet with given list of cells.
   * @param currSpreadSheet
   */
  public BasicWorksheet(ArrayList<ArrayList<Cell>>  currSpreadSheet){
    this.currSpreadSheet = currSpreadSheet;
  }

  /**
   * This is a Builder that returns a worksheet with the default parameters.
   * @return a basic build Worksheet.
   */
  public static Builder defaultBuilder() {
    return new Builder();
  }


  /**
   *This helps us locate the cells in the Arraylist of Arraylist of cells so we can
   * make changes to specific cells.
   * @param coord is the location of the cell.
   * @return the cell at the given coordinates.
   */
  @Override
  public Cell getCellAt(Coord coord)
  {
     return currSpreadSheet.get(coord.col-1).get(coord.row -1);
  }


  /**
   *This is a static class that allows us to build the worksheet.
   */
  public static final class Builder implements WorksheetBuilder<Spreadsheet> {

    //set to zero to test empty worksheet
    private int height = 26;
    private int width = 26;
    private ArrayList<ArrayList<Cell>> currSpreadSheet = new ArrayList<>();


    /**
     *This was meant for us to set the size of the list, still trying to figure out if needed and
     * this is left so we can try and implement a set height and width of a spreadsheet.
     * @param height
     * @return a Builde.
     */
    public Builder setHeight(int height) {
      if (height < 0) {
        throw new IllegalArgumentException("Height cannot be negative");
      }
      this.height = height;
      return this;
    }

    /**
     *This was meant for us to set the size of the list, still trying to figure out if needed and
     * this is left so we can try and implement a set height and width of a spreadsheet.
     * @param width
     * @return a Builder
     */
    public Builder setWidth(int width) {
      if (height < 0) {
        throw new IllegalArgumentException("Height cannot be negative");
      }
      this.width = width;
      return this;
    }

    /**
     *This was to set the list of cells, we need to work on the implementation of this but we know
     * it will be needed.
     * @return a Builder
     */
    public Builder setGrid() {
      currSpreadSheet = new ArrayList<>();
      return this;
    }

    /**
     *This is a function that creates a cell as part of the builder to create a worksheet.
     * @param col the column of the new cell (1-indexed)
     * @param row the row of the new cell (1-indexed)
     * @param contents the raw contents of the new cell: may be {@code null}, or any string.
     *                 Strings beginning with an {@code =} character should be
     *                 treated as formulas; all other strings should be treated as number or
     *                 boolean values if possible, and string values otherwise.
     * @return a Builder
     */
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

    /**
     * This creates a builder of a blank cell as a redundancy of the blank cell constructor.
     * @param col
     * @param row
     * @return a Builder
     */
    public Builder blankCell(int col, int row) {
      Coord coord = new Coord(col, row);
      Cell cell = new Cell(coord);
      currSpreadSheet.get(col -1).add(row -1, cell);
      return this;
    }


    /**
     *This creates the worksheet from the builder.
     * @return BasicWorksheet
     */
    @Override
    public BasicWorksheet createWorksheet() {
      if (currSpreadSheet.size() == 0 || currSpreadSheet.get(0).size() == 0) {
        throw new IllegalArgumentException("Null width or height");
      }
      return new BasicWorksheet(currSpreadSheet);
    }


  }
}
