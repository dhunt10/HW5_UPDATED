package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;

public class Cell {

  private Formula contents;
  private Coord coords;
  private String rawContents;
  private Formula evaluatedData;

  public Cell(Coord coords, Formula contents){
    this.coords = coords;
    this.contents = contents;
  }
  public Cell(Coord coords){
    this.coords = coords;
    this.contents = new StringValue("");
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
