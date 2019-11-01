package edu.cs3500.spreadsheets.model.values;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;

public class Cell {

  private Formula contents;
  private Coord coords;
  private Formula evaluatedData;

  public Cell(Coord coords, Formula contents){
    this.coords = coords;
    this.contents = contents;
  }

  public Value getEvaluated(Coord coord){
    return null;
  }

  public Formula getContents(){
    return this.contents;
  }

  public void setContents(Formula contents){
    this.contents = contents;
  }

}
