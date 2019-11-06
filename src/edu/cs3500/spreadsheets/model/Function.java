package edu.cs3500.spreadsheets.model;

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

  public Function(String item) {
    sexp = Parser.parse(item);
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
    String fucntionName;
    List<Value> argValues = new ArrayList<>();
    List<Formula> args = new ArrayList<>();
    for (Formula f: args) {
      argValues.add(f.evaluate());
    }

    return
  }
}
