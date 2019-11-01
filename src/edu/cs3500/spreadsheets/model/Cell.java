package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.reference.Reference;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import java.util.List;

public class Cell {

  private Formula contents;
  private Coord coords;
  private Formula evaluatedData;

  public Cell(Coord coords, Formula contents) {
    this.coords = coords;
    this.contents = contents;
  }
  public Cell(Coord coords) {
    this.coords = coords;
    this.contents = new StringValue("");
  }

  public Value getEvaluated(Coord coord) {
    try {
      Reference ref = (Reference) contents;
      List<Coord> reference = new Reference(contents);
    }
    catch (IllegalArgumentException e) {

    }
    try {
      Value value = (Value) contents;
    }
    catch (IllegalArgumentException e) {

    }
    try {
      Function func = (Function) contents;
    }
    catch (IllegalArgumentException e) {

    }

  }

  public Formula getContents() {
    return this.contents;
  }

  public void setContents(Formula contents) {
    this.contents = contents;
  }

}

