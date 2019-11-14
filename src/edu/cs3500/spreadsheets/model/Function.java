package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.reference.Reference;
import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.NumValue;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.awt.SystemTray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Defines what a function will be and how it is interacted within the program.
 */
public class Function implements Formula {

  Sexp sexp;
  String functionName;

  List<Formula> args;
  Map<Coord, Cell> mapOfCells = null;

  /**
   * Constructor for a function.
   * @param item raw string to be parsed.
   * @param args list of all the arguments in the function.
   * @param functionName the name of the function to perform.
   */
  public Function(List<Formula> args, String functionName) {
    this.args = args;
    this.functionName = functionName;
  }

  /**
   * Gets the current sexp.
   * @return the sexp.
   */
  public Sexp getSexp() {
    return sexp;
  }

  /**
   * This method will be called to evaluate every formula in our list of arguments.
   * @param mapOfCells this map will be used in the event that a cell contains a reference.
   * @param useless sends the function name to the reference in that case.
   * @return a Value to be entered back into the cell.
   */
  @Override
  public Value evaluate(Map<Coord, Cell> mapOfCells, String useless) {
    List<Value> argValues = new ArrayList<>();
    for (Formula f: this.args) {
      argValues.add(f.evaluate(mapOfCells, useless));
    }

    return evaluateHelper(argValues, useless);
  }


  /**
   * Helper to iterate through list of values, depending on the formula name.
   * @param values list of values to be operated on.
   * @return returns a final value to be set as evaluated value.
   */
  public Value evaluateHelper(List<Value> values, String func) {
    if (this.functionName.equals("SUM")) {
      double ans = 0;
      for (Formula a : values.subList(1, values.size())) {
        ans = ans + Double.parseDouble(a.evaluate(mapOfCells, func).toString());
      }
      return new NumValue(ans);
    }

    else if (this.functionName.equals("PROD")) {
      double ans = 1;
      for (Formula a : values.subList(1, values.size())) {
        ans = ans * Double.parseDouble(a.evaluate(mapOfCells, func).toString());
      }
      return new NumValue(ans);
    }

    else if (this.functionName.equals("<")) {

      boolean ans = Double.parseDouble(values.get(1).evaluate(mapOfCells, func).toString())
          < Double.parseDouble(values.get(2).evaluate(mapOfCells, func).toString());
      return new BooleanValue(ans);
    }

    else if (this.functionName.equals("COMB")) {
      StringBuilder sb = new StringBuilder();

      for (Formula a : values.subList(1, values.size())) {
        sb.append(a.evaluate(mapOfCells, func));
      }

      return new StringValue(sb.toString());
    }

    else {
      try {
        return new NumValue(Double.parseDouble(String.valueOf(values.get(0))));
      }
      catch (Exception e) {
        throw new IllegalArgumentException("Not a valid operator");
      }

    }

  }
}
