package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.values.StringValue;
import edu.cs3500.spreadsheets.model.values.Value;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


/**
 * Defines what a cell is and how it is defined.
 */
public class Cell {

  private Formula contents;
  private Coord coord;
  private Value evaluatedData;

  /**
   * Construtor for a cell that will have contents.
   * @param coords the coordinates of the cell in currSpreadSheet.
   * @param contents content of the cell, not yet evaluated.
   */
  public Cell(Coord coords, Formula contents) {
    this.coord = coords;
    this.contents = contents;
  }

  /**
   * Construtor for a cell that will be blank.
   * @param coord the coordinates of the cell in currSpreadSheet.
   */
  public Cell(Coord coord) {
    this.coord = coord;
    this.contents = new StringValue("");
    this.evaluatedData = new StringValue("");
  }

  /**
   * Returns the raw contents of the cell.
   * @return raw contents of the cell.
   */
  public Formula getContents() {
    return this.contents;
  }

  /**
   * Changes the current content of the cell.
   * @param contents the newly inputted content.
   */
  public void setContents(Formula contents) {
    this.contents = contents;
  }

  /**
   * Gets data that has been evaluated.
   * @return data that has been evaluated.
   */
  public String getEvaluatedData() {
    return this.evaluatedData.toString();
  }

  /**
   * Setter to set the final evaluated data to appear to user.
   * @param value value to be set as the evaluated value.
   */
  public void setEvaluatedData(Value value) {
    this.evaluatedData = value;
  }

  public JPanel drawSelf() {
    JLabel field = new JLabel(this.toString());
    JPanel cell = new JPanel();
    cell.add(field);
    cell.setBackground(new Color(196, 198, 255));
    //cell.setPreferredSize(new Dimension(20, 10));
    cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    return cell;
  }


  @Override
  public String toString() {
    return evaluatedData.toString();
  }

}

