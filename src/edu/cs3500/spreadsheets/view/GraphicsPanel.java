package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {
  private Map<Coord, Cell> curr;


  /**
   * Make a GraphicsPanel.
   */
  public GraphicsPanel() {
    super();
    curr = new HashMap<>();
    this.setBackground(Color.WHITE);
  }

  public void setcurrState(Map<Coord, Cell> curr) {
    this.curr = curr;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for (Coord c: curr.keySet()) {
      curr.get(c).drawSelf(g2d);
    }
  }

}
