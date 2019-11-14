package edu.cs3500.spreadsheets.model.reference;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.values.Value;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Reference is a type that references any cell.
 * A reference can be a reference to single cell or a block of cells.
 * For example: A1 would be a single reference and A1:B7 would be a block of cells.
 */
public class Reference implements Formula {

  List<String> refs;
  String references;
  List<Coord> evaluatedRefs;

  /**
   * Contructor. takes in a string that should be formatted as ["Cell1:Cell2"] or ["Cell1]. The
   * constructor takes in a string, calls a function to make a list of the cells. being references
   * and then calls an additional function to return a list of coordinates.
   *
   * @param references a string formatted as such: ["Cell1:Cell2"] or ["Cell1].
   */
  public Reference(String references) {
    this.references = references;
    String[] splitter = references.split(":");

    if (splitter.length > 1) {
      refs = referenceListMaker(splitter[0], splitter[1]);
    } else {
      refs = referenceListMaker(splitter[0]);
    }

    this.evaluatedRefs = getRefs();
  }

  /**
   * Makes a list of single reference cell. Polymorphic design allows for just one cell.
   *
   * @param firstBound the single cell to be parsed through.
   * @return returns a list of 1 single reference cell.
   */
  public List<String> referenceListMaker(String firstBound) {

    List<String> bounds = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    sb.append(firstBound.charAt(0));
    sb.append(firstBound.charAt(1));

    bounds.add(sb.toString());
    return bounds;
  }

  /**
   * Makes a list of all the cells within a given range.
   *
   * @param firstBound  range is defined with firstBound as the start.
   * @param secondBound range is defined with second bound as the start.
   * @return a list of strings that hold all the points being referenced.
   */
  public List<String> referenceListMaker(String firstBound, String secondBound) {
    List<String> bounds = new ArrayList<>();

    int zeroDiff = Math.abs(firstBound.charAt(0) - secondBound.charAt(0)) + 1;
    int oneDiff = Math.abs(firstBound.charAt(1) - secondBound.charAt(1)) + 1;

    if (firstBound.charAt(0) == secondBound.charAt(0)) {
      for (int i = 0; i < oneDiff; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstBound.charAt(0));
        sb.append(firstBound.charAt(1) + i);
        bounds.add(sb.toString());
      }
    } else if (firstBound.charAt(1) == secondBound.charAt(1)) {
      for (int i = 0; i < zeroDiff; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append((char) firstBound.charAt(0) + 1);
        sb.append(firstBound.charAt(1));
        bounds.add(sb.toString());
      }
    } else {
      for (int i = 0; i < zeroDiff; i++) {
        for (int j = 0; j < oneDiff; j++) {
          StringBuilder sb = new StringBuilder();
          sb.append((char) firstBound.charAt(0) + j);
          sb.append(firstBound.charAt(1) + i);
          bounds.add(sb.toString());
        }
      }

    }

    return bounds;
  }

  /**
   * converts the strings made in referenceListMaker to coordinates.
   *
   * @return a list of coordinates being referenced.
   */
  public List<Coord> getRefs() {
    List<Coord> references = new ArrayList<>();
    System.out.println(this.refs.size());
    for (int i = 0; i < this.refs.size(); i++) {
      int col = Coord.colNameToIndex(String.valueOf(this.refs.get(i).charAt(0)));
      int row = Integer.parseInt(String.valueOf(this.refs.get(i).charAt(1)));

      Coord coord = new Coord(col, row);
      references.add(coord);
    }
    return references;
  }

  @Override
  public Value evaluate(Map<Coord, Cell> mapOfCells) {
    /*List<Value> values = new ArrayList<>();
    for (Coord c : evaluatedRefs) {
      values.add(mapOfCells.get(c).getContents().evaluate(mapOfCells));
    }

    return this.evaluate(mapOfCells);
  }*/
    System.out.print(evaluatedRefs);
    return mapOfCells.get(evaluatedRefs.get(0)).getEvaluatedData();
  }
}
