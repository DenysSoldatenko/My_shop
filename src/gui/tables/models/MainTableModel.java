package gui.tables.models;

import gui.Refresh;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import models.Common;
import settings.Text;

/**
 * The MainTableModel class serves as the base class for table models used in the GUI.
 * It provides common functionality for managing table data and refreshing the table.
 */
public abstract class MainTableModel extends AbstractTableModel implements Refresh {

  protected List<? extends Common> data;
  protected List<String> columns;

  public MainTableModel(List<? extends Common> data, String[] columns) {
    this.data = data;
    this.columns = new ArrayList<>(Arrays.asList(columns));
  }

  @Override
  public int getRowCount() {
    return data.size();
  }

  @Override
  public int getColumnCount() {
    return columns.size();
  }

  @Override
  public String getColumnName(int columnIndex) {
    return Text.get(columns.get(columnIndex));
  }

  @Override
  public Class<?> getColumnClass(int columnIndex) {
    Object obj = getValueAt(0, columnIndex);
    if (obj == null) {
      return Object.class;
    }
    return obj.getClass();
  }

  @Override
  public void refresh() {
    updateData();
    fireTableStructureChanged();
    fireTableDataChanged();
  }

  public Common getCommonByRow(int row) {
    return data.get(row);
  }

  protected abstract void updateData();
}
