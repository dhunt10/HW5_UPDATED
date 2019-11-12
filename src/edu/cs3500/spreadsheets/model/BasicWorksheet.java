package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.WorksheetReader.WorksheetBuilder;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
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

  private final Map<Coord, Cell> currSpreadSheet;
  private List<Coord> coordList;

  /**
   * This build the worksheet with given list of cells.
   *
   * @param currSpreadSheet array list of array list holding the cells
   */
  public BasicWorksheet(Map<Coord, Cell> currSpreadSheet, List<Coord> coordList) {
    this.currSpreadSheet = currSpreadSheet;
    this.coordList = coordList;
    fillBlank();
    getEvaluatedCells();
  }

  /**
   * This is a Builder that returns a worksheet with the default parameters.
   *
   * @return a basic build Worksheet.
   */
  public static Builder defaultBuilder() {
    return new Builder();
  }

  /**
   * Function to run through the map of cells and evaluate each individual cell.
   * This function is called directly after a spreadsheet has been created and will subsequently
   * be called after every new cell addition.
   */
  public void getEvaluatedCells() {

    for (Coord item : coordList) {
      Sexp sexp = Parser.parse(currSpreadSheet.get(item).getContents().toString());
      Formula deliverable = sexp.accept(new SexpToFormula());
      currSpreadSheet.get(item).setEvaluatedData(deliverable.evaluate(currSpreadSheet));
    }
  }

  /**
   * This creates a builder of a blank cell as a redundancy of the blank cell constructor.
   * @param coord coordinate for new blank cell.
   * @return a Builder
   */
  public void blankCell (Coord coord){
    Cell cell = new Cell(coord);
    currSpreadSheet.put(coord, cell);
    coordList.add(coord);
  }

  /**
   *
   */
  public void fillBlank() {

    int highRow = 0;
    int highCol = 0;
    for (Coord coord : coordList) {
      if (coord.col > highCol) {
        highCol = coord.col;
      }

      if (coord.row > highRow) {
        highRow = coord.row;
      }
    }

    for (int i = highCol; i > 0; i--) {
      for (int j = highRow; j > 0; j--) {
        try {
          getCellAt(new Coord(i, j));
        }
        catch (NullPointerException e) {
          blankCell(new Coord(i,j));
        }
      }

    }

  }

  /**
   * This helps us locate the cells in the Arraylist of Arraylist of cells so we can make changes to
   * specific cells.
   *
   * @param coord is the location of the cell.
   * @return the cell at the given coordinates.
   */
  @Override
  public Cell getCellAt(Coord coord) {
    return currSpreadSheet.get(coord);
  }

  @Override
  public Map<Coord, Cell> getCurrSpreadSheet() {
    return currSpreadSheet;
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
      return this;

    }

    /**
     * Getter to return the value of a given key in the spreadsheet map.
     * @param coord coordinate of cell you wish to access.
     * @return the cell of the given coordinate.
     */
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
        return new BasicWorksheet(currSpreadSheet, coordList);
      }

      public Map<Coord, Cell> getCurrSpreadSheet() {
        return currSpreadSheet;
      }



    }
  }
