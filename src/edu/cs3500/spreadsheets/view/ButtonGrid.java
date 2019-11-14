package edu.cs3500.spreadsheets.view;

import edu.cs3500.spreadsheets.model.Cell;
import edu.cs3500.spreadsheets.model.Coord;
import java.awt.GridLayout;
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class ButtonGrid extends JFrame{

  private Map<Coord, Cell> curr;
  JFrame frame=new JFrame(); //creates frame
  JLabel[][] grid; //names the grid of buttons
  JPanel panel=new JPanel();

  public ButtonGrid(Map<Coord, Cell> curr, int width, int length){ //constructor
    this.curr = curr;
    JScrollPane scrollBar=new JScrollPane(panel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    frame.setLayout(new GridLayout(width,length)); //set layout


    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.add(scrollBar);
    frame.setSize(400, 400);
    //frame.pack(); //sets appropriate size for frame
    frame.setVisible(true); //makes frame visible
  }

  public void display() {
    this.setVisible(true);
  }

}
