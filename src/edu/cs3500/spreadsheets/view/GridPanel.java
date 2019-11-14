package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.SpringLayout;
import java.awt.*;

/**
 * This is a representation of the panel of cells (also panels) that will go into
 * our JFrame.
 */
public class GridPanel extends JPanel {
  private Map<Coord, Cell> curr;


  /**
   * Make a GridPanel, the contstructor. In the constructor we fill the grid with empty cells,
   * then we set the size of each panel in the GridBagLayout, and finally we make
   * the header cells a different color and not cells that can be modified.
   */
  public GridPanel(int col, int row, Map<Coord, Cell> curr) {
    super();
    this.curr = curr;
    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;

    //first loop to create empty sheet
    setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
    for (int i = 0; i < col; i++) {
      for (int j = 0; j < row; j++) {
        JLabel field = new JLabel(" ");
        Cell template = new Cell(new Coord(i + 1, j + 1));
        JPanel cell = template.drawSelf();
        cell.add(field);
        cell.setBackground(new Color(196, 198, 255));
        c.gridx = i;
        c.gridy = j;
        c.ipadx = 30;
        c.ipady = 10;
        cell.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        if (j == 0 && i == 0) {
          cell.setBackground(new Color(74, 77, 145));
        }
        if (j == 0 && i >= 1) {
          JLabel field2 = new JLabel(Coord.colIndexToName(i));
          cell.setBackground(new Color(74, 77, 145));
          cell.add(field2, c);
        }
        if (i == 0 && j >= 1) {
          Coord coord = new Coord(i+1, j );
          JLabel field3 = new JLabel(String.valueOf(coord.row));
          cell.setBackground(new Color(74, 77, 145));
          cell.add(field3, c);
        }
        for (Coord coord: curr.keySet()) {
          if(coord.row == j && coord.col == i)
            add(curr.get(coord).drawSelf(), c); //adds labels to grid
        }
        add(cell, c);
      }
    }

  }

  /**
   * Will need this I assume next assignment when we can interact with the spreadsheet.
   * @param curr is the current list of cells
   */
  public void setcurrState(Map<Coord, Cell> curr) {
    this.curr = curr;
  }

}

