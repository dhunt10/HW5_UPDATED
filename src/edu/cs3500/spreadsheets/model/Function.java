package edu.cs3500.spreadsheets.model;

<<<<<<< HEAD
import edu.cs3500.spreadsheets.sexp.Sexp;

public class Function implements Formula {
  String formula;
  Sexp rawFormula;

  private Function(Sexp sexp) {

  }

  @Override
  public void evaluate() {

  }

  @Override
  public void getFormula(Coord coord) {

=======
import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.NumValue;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Defines what a function will be and how it is interacted within the program.
 */
public class Function implements Formula {

  Sexp sexp;
  String functionName;
  List<Formula> args;

  public Function(String item, List<Formula> args, String functionName) {
    this.args = args;
    sexp = Parser.parse(item);
    this.functionName = functionName;
  }

  private static double productHelper(List<Double> values) {
    double prod = 0;
    for (int i = 0; i < values.size(); i++) {
      prod = prod * values.get(i);
    }
    return prod;
  }

  private static boolean compareLessHelper(double smaller, double larger) {
    return smaller < larger;
  }

  private static double sumHelper(List<Double> values) {
    double sum = 0;
    for (int i = 0; i < values.size(); i++) {
      sum = sum + values.get(i);
    }
    return sum;
  }

  private List<String> sortHelper(List<String> values) {
    Collections.sort(values);
    return values;
  }

  public Sexp getSexp() {
    return sexp;
  }

  @Override
  public Value evaluate() {
    String functionName = this.functionName;
    List<Value> argValues = new ArrayList<>();
    for (Formula f: this.args) {
      argValues.add(f.evaluate());
    }

    return evaluateHelper(argValues);
  }


  public Value evaluateHelper(List<Value> values) {
    Sexp sexp = Parser.parse(values.toString());
    if (this.functionName == "SUM") {
      double ans = 0;
      for (Formula a : values) {
        ans = ans + Double.parseDouble(a.evaluate().toString());
      }
      return new NumValue(ans);
    }

    else if (this.functionName == "PROD") {
      double ans = 1;
      for (Formula a : values) {
        ans = ans * Double.parseDouble(a.evaluate().toString());
      }
      return new NumValue(ans);
    }

    else if (this.functionName == "<") {
      boolean ans = Double.parseDouble(values.get(1).evaluate().toString())
          < Double.parseDouble(values.get(1).evaluate().toString());
      return new BooleanValue(ans);
    }

    else if (this.functionName == "COMB") {
      StringBuilder sb = new StringBuilder();

      for (Formula a : values) {
        sb.append(a.evaluate());
      }

      return new StringValue(sb.toString());
    }
    else {
      throw new IllegalArgumentException("Not a valid operator");
    }

>>>>>>> e1b36a44c8cd76964ebb557efdbf37dab1208bd6
  }
}
