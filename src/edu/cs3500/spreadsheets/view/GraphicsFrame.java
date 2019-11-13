package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

/**
 *
 *
 */
public class GraphicsFrame extends JFrame {

  private GraphicsPanel graphicsPanel;

  /**
   *
   * @param curr
   * @param width
   * @param height
   */
  public GraphicsFrame(Map<Coord, Cell> curr,
      int width, int height) {
    super();
    this.setPreferredSize(new Dimension(width,  height));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    graphicsPanel = new GraphicsPanel();
    graphicsPanel.setBounds(0, 0, width, height);
    JScrollPane jp = new JScrollPane(graphicsPanel);
    this.add(jp, BorderLayout.CENTER);

    graphicsPanel.setcurrState(curr);

    this.pack();
  }

  /**
   *
   * @param curr
   */
  public void updatecurrState(Map<Coord, Cell> curr) {
    graphicsPanel.setcurrState(curr);
    this.repaint();
  }

  /**
   *
   */
  public void display() {
    this.setVisible(true);
  }
}
