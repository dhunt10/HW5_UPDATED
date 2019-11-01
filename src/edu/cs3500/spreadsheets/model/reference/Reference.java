package edu.cs3500.spreadsheets.model.reference;

import edu.cs3500.spreadsheets.model.Coord;
import edu.cs3500.spreadsheets.model.Formula;
import edu.cs3500.spreadsheets.model.values.BooleanValue;
import java.util.ArrayList;
import java.util.List;

public class Reference implements Formula {

  List<String> refs;
  String references;
  List<Coord> evaluatedRefs;

  public Reference(String references) {
    this.references = references;
    String[] splitter = references.split(":");

    if (splitter.length > 1) {
      refs = referenceListMaker(splitter[0], splitter[1]);
    }
    else {
      refs = referenceListMaker(splitter[0]);
    }

    this.evaluatedRefs = getRefs();
  }

  public List<String> referenceListMaker(String firstBound) {

    List<String> bounds = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    sb.append(firstBound.charAt(0));
    sb.append(firstBound.charAt(1));

    bounds.add(sb.toString());

    return bounds;
  }

  public List<String> referenceListMaker(String firstBound, String secondBound) {
    List<String> bounds = new ArrayList<>();

    int zeroDiff = Math.abs(firstBound.charAt(0) - secondBound.charAt(0)) + 1;
    int oneDiff = Math.abs(firstBound.charAt(1) - secondBound.charAt(1)) + 1;

    if (firstBound.charAt(0) == secondBound.charAt(0)) {
      for (int i = 0; i < oneDiff; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstBound.charAt(0));
        sb.append(firstBound.charAt(1) + i);
        bounds.add(sb.toString());
      }
    }

    else if (firstBound.charAt(1) == secondBound.charAt(1)) {
      for (int i = 0; i < zeroDiff; i++) {
        StringBuilder sb = new StringBuilder();
        sb.append(firstBound.charAt(0));
        sb.append(firstBound.charAt(1) + i);
        bounds.add(sb.toString());
      }
    }

    else {
      for (int i = 0; i < zeroDiff; i++) {
        for (int j = 0; j < oneDiff; j++) {
          StringBuilder sb = new StringBuilder();
          sb.append(firstBound.charAt(0) + j);
          sb.append(firstBound.charAt(1) + i);
          bounds.add(sb.toString());
        }
      }

    }

    return bounds;
  }

  public List<Coord> getRefs() {
    List<Coord> references = null;
    for (int i = 0; i < this.refs.size(); i ++) {
      int col = Coord.colNameToIndex(this.refs.get(i));
      int row = Integer.parseInt(this.refs.get(i));
      Coord coord = new Coord(col, row);
      references.add(coord);
    }
    return references;
  }

  @Override
  public boolean equals(Object o){

    if (this == o) {
      return true;
    }

    if (!(o instanceof Reference)) {
      return false;
    }

    Reference ref = (Reference) o;
    if (ref == this) {
      return true;
    }
    else {
      return false;
    }
  }

}
