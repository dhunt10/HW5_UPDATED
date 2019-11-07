package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class GraphicsFrame extends JFrame {

  private GraphicsPanel graphicsPanel;

  public GraphicsFrame(ArrayList<ArrayList<Cell>> curr, int xAxis, int yAxis,
      int width, int height) {
    super();
    this.setPreferredSize(new Dimension(xAxis + width, yAxis + height));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    graphicsPanel = new GraphicsPanel();
    graphicsPanel.setBounds(xAxis, yAxis, width, height);
    JScrollPane jp = new JScrollPane(graphicsPanel);
    this.add(jp, BorderLayout.CENTER);

    graphicsPanel.setcurrState(curr);

    this.pack();
  }

  public void updatecurrState(ArrayList<ArrayList<Cell>> curr) {
    graphicsPanel.setcurrState(curr);
    this.repaint();
  }

  public void display() {
    this.setVisible(true);
  }
}
