package edu.cs3500.spreadsheets.view;

/**
 *
 */
public interface IView {


  /**
   *
   * @param filePath
   */
  void saveTo(String filePath);

  /**
   *
   */
  void display();

  /**
   *
   * @return
   */
  String buildTextView();
}
