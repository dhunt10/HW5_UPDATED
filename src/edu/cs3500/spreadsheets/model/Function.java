package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.sexp.Parser;
import edu.cs3500.spreadsheets.sexp.Sexp;
import java.text.Normalizer.Form;

public class Function implements Formula {

  Sexp sexp;

  Function(String item) {
    sexp = Parser.parse(item);
  }

}
