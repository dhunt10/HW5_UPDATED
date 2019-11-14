package edu.cs3500.spreadsheets.view;

/**
 *This is the interface for all our possible views for our spreadsheet.
 */
public interface IView {


  /**
   *This method will save an inputted file that is evaluated to an out file.
   * @param filePath the path of the file to save the evaluated spreadsheet to.
   */
  void saveTo(String filePath);

  /**
   *This will be called when we want our view to be displayed.
   */
  void display();

  /**
   *this will build a text view, inherited because there may be other views that
   * need a text view component.
   * @return a String representation of our evaluated spreadsheet.
   */
  String buildTextView();
}
