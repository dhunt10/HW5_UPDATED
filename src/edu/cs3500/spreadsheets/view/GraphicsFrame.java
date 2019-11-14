package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

/**
 *This represents our frame which takes in our panel and has
 * external window properties such as scrollbars that makes
 * our spreadsheet window look nice.
 */
public class GraphicsFrame extends JFrame {

  private Map<Coord, Cell> curr;
  private GridPanel gridPanel;
  private JFrame frame=new JFrame(); //creates frame
  private JLabel[][] grid; //names the grid of buttons

  /**
   * This is the constructor for the frame.
   * @param curr the cells to be inputted into the frame.
   * @param width how wide the frame will be, the starting window.
   * @param height how tall the fame will be, the starting window.
   */
  public GraphicsFrame(Map<Coord, Cell> curr,
      int width, int height) {

    super();
    this.setPreferredSize(new Dimension(width,  height));
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    this.setLayout(new BorderLayout());
    gridPanel = new GridPanel(width, height, curr);

    JScrollPane scrollBar=new JScrollPane(gridPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    this.add(scrollBar, BorderLayout.CENTER);

    //graphicsPanel.setcurrState(curr);
    this.pack();
    this.setSize(800, 500);
  }

  /**
   *Will need this for the future implementations when the user has to interact with the sheet
   * and we will have to update the sheet based on the interaction.
   * @param curr
   */
  public void updatecurrState(Map<Coord, Cell> curr) {
    gridPanel.setcurrState(curr);
    this.repaint();
  }

  /**
   *This method makes the frame visible.
   */
  public void display() {
    this.setVisible(true);
  }
}