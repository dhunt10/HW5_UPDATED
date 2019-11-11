package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.NumValue;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
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

  public Function(String item, List<Formula> args, String functionName) {
    this.args = args;
    sexp = Parser.parse(item);
    this.functionName = functionName;
  }

  public Sexp getSexp() {
    return sexp;
  }

  @Override
  public Value evaluate(Map<Coord, Cell> mapOfCells) {
    String functionName = this.functionName;
    List<Value> argValues = new ArrayList<>();
    for (Formula f: this.args) {
      argValues.add(f.evaluate(mapOfCells));
    }

    return evaluateHelper(argValues);
  }


  public Value evaluateHelper(List<Value> values) {
    Sexp sexp = Parser.parse(values.toString());
    if (this.functionName == "SUM") {
      double ans = 0;
      for (Formula a : values) {
        ans = ans + Double.parseDouble(a.evaluate(mapOfCells).toString());
      }
      return new NumValue(ans);
    }

    else if (this.functionName == "PROD") {
      double ans = 1;
      for (Formula a : values) {
        ans = ans * Double.parseDouble(a.evaluate(mapOfCells).toString());
      }
      return new NumValue(ans);
    }

    else if (this.functionName == "<") {
      boolean ans = Double.parseDouble(values.get(1).evaluate(mapOfCells).toString())
          < Double.parseDouble(values.get(1).evaluate(mapOfCells).toString());
      return new BooleanValue(ans);
    }

    else if (this.functionName == "COMB") {
      StringBuilder sb = new StringBuilder();

      for (Formula a : values) {
        sb.append(a.evaluate(mapOfCells));
      }

      return new StringValue(sb.toString());
    }
    else {
      throw new IllegalArgumentException("Not a valid operator");
    }

  }
}
