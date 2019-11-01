package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.reference.Reference;
import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.NumValue;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.sexp.Sexp;
import edu.cs3500.spreadsheets.sexp.SexpVisitor;
import java.util.List;

public class SexpToFormula implements SexpVisitor<Formula> {

  @Override
  public Formula visitBoolean(boolean b) {
    return new BooleanValue(b);
  }

  @Override
  public Formula visitNumber(double d) {
    return new NumValue(d);
  }

  @Override
  public Formula visitSList(List<Sexp> l) {
    return null;
  }

  @Override
  public Formula visitSymbol(String s) {
    return null;
  }

  @Override
  public Formula visitString(String s) {
    return new StringValue(s);
  }
}
