package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;

public class GraphicsPanel extends JPanel {
  private ArrayList<ArrayList<Cell>> curr;


  /**
   * Make a GraphicsPanel with a certain state.
   */
  public GraphicsPanel() {
    super();
    curr = new ArrayList<>();
    this.setBackground(Color.WHITE);
  }

  public void setcurrState(ArrayList<ArrayList<Cell>> curr) {
    this.curr = curr;
  }

  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    for(int i = 0; i < curr.size(); i++){
      for(int j = 0; i <curr.get(i).size(); j++){
        curr.get(i).get(j).drawSelf(g2d);
      }
    }
  }

}
