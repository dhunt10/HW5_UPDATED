package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.model.reference.Reference;

import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
<<<<<<< HEAD
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

=======
import java.text.Normalizer.Form;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a worksheet representation that has the basic needs that were
 * in the specifications of the assignment. We made it basic just in case
 * that we are given different types of worksheets later on.
 */
public class BasicWorksheet implements Spreadsheet {

  private List<Coord> coordList = new ArrayList<>();

  /**
   * This build the worksheet with given list of cells.
   *
   * @param currSpreadSheet array list of array list holding the cells
   */
  public BasicWorksheet(Map<Coord, Cell> currSpreadSheet) {
    this.currSpreadSheet = currSpreadSheet;
  }

  /**
   * This is a Builder that returns a worksheet with the default parameters.
   *
   * @return a basic build Worksheet.
   */
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
  public static Builder defaultBuilder() {
    return new Builder();
=======

  public BasicWorksheet() {

  }

  @Override
  public Cell getCellAt(Coord coord) {
    return currSpreadSheet.get(coord.col).get(coord.row);
  }

  /**
   * This helps us locate the cells in the Arraylist of Arraylist of cells so we can make changes to
   * specific cells.
   *
   * @param coord is the location of the cell.
   * @return the cell at the given coordinates.
   */
  @Override
<<<<<<< HEAD
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
=======
  public Cell getCellAt(Coord coord) {
    return currSpreadSheet.get(coord);
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
  }

  @Override
  public Map<Coord, Cell> getCurrSpreadSheet() {
    return currSpreadSheet;
  }

  /*public List<Value> operatorDec(Reference reference) {
    Reference ref = new Reference(reference.toString());
    List<Coord> refList = ref.getRefs();
    List<Value> valueList = new ArrayList<>();
    for (Coord item : refList) {
      valueList.add(getEvaluatedCellAt(item));
    }

<<<<<<< HEAD
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
=======
    return valueList;
  }*/

  public Value operatorDec(Value value) {
    return value;
  }

  /**
   * This is a static class that allows us to build the worksheet.
   */
  public static final class Builder implements WorksheetBuilder<Spreadsheet> {

    private Map<Coord, Cell> currSpreadSheet = new HashMap<Coord, Cell>();
    private List<Coord> coordList = new ArrayList<>();


    /**
     * This is a function that creates a cell as part of the builder to create a worksheet.
     *
     * @param col      the column of the new cell (1-indexed)
     * @param row      the row of the new cell (1-indexed)
     * @param contents the raw contents of the new cell: may be {@code null}, or any string. Strings
     *                 beginning with an {@code =} character should be treated as formulas; all
     *                 other strings should be treated as number or boolean values if possible, and
     *                 string values otherwise.
     * @return a Builder
     */
    @Override
    public Builder createCell(int col, int row, String contents) {
      Coord coord = new Coord(col, row);
      Sexp sexp = Parser.parse(contents);
      Formula formula = sexp.accept(new SexpToFormula());

      Cell cell = new Cell(coord, formula);
      currSpreadSheet.put(coord, cell);
      coordList.add(coord);
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
      return this;

    }


<<<<<<< HEAD
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
=======
    public void getEvaluatedCells() {

      for (Coord item : coordList) {
        Sexp sexp = Parser.parse(currSpreadSheet.get(item).getContents().toString());
        Formula deliverable = sexp.accept(new SexpToFormula());
        currSpreadSheet.get(item).setEvaluatedData(deliverable.evaluate());
      }
    }

      /**
       * This creates a builder of a blank cell as a redundancy of the blank cell constructor.
       * @param coord coordinate for new blank cell.
       * @return a Builder
       */
      public Builder blankCell (Coord coord){
        Cell cell = new Cell(coord);
        currSpreadSheet.put(coord, cell);
        return this;
      }

      public Cell getCellAt (Coord coord){
        return currSpreadSheet.get(coord);
      }

      /**
       *This creates the worksheet from the builder.
       * @return BasicWorksheet
       */
      @Override
      public BasicWorksheet createWorksheet () {
        if (currSpreadSheet.size() == 0) {
          throw new IllegalArgumentException("Null width or height");
        }
        return new BasicWorksheet(currSpreadSheet);
      }
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6

      public Map<Coord, Cell> getCurrSpreadSheet() {
        return currSpreadSheet;
      }



    }
  }
<<<<<<< HEAD

}
=======
>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
