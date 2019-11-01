package edu.cs3500.spreadsheets.model;

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

  }
}
