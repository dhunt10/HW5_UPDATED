package edu.cs3500.spreadsheets.model;

import edu.cs3500.spreadsheets.model.values.BooleanValue;
import edu.cs3500.spreadsheets.model.values.Value;
import java.util.List;

public interface iFormulaVisitor extends iFunc<List<Value>, Value>{

  R visitBooleanValue(BooleanValue b);
}
