package edu.cs3500.spreadsheets.view;

public interface IView {


  void saveTo(String filePath);
  void display();
  String buildTextView();
}
