package gui.tables;

import gui.Refresh;
import gui.menus.TablePopupMenu;
import gui.renders.MainTableCellRenderer;
import gui.renders.TableHeaderIconRenderer;
import gui.tables.models.MainTableModel;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import settings.Text;
import settings.styles.ConstantStyle;
import settings.styles.DimensionStyle;
import settings.styles.FontStyle;

/**
 * The TableData class represents a table in the GUI.
 */
public abstract class TableData extends JTable implements Refresh {

  private final String[] columns;
  private final ImageIcon[] icons;
  private final TablePopupMenu popup;

  public TableData(MainTableModel model, String[] columns, ImageIcon[] icons) {
    super(model);
    this.columns = columns;
    this.icons = icons;
    this.popup = new TablePopupMenu();

    getTableHeader().setFont(FontStyle.FONT_TABLE_HEADER);
    setFont(FontStyle.FONT_TABLE);
    setRowHeight(getRowHeight() + ConstantStyle.TABLE_ADD_ROW_HEIGHT);

    setAutoCreateRowSorter(true);
    setPreferredScrollableViewportSize(DimensionStyle.DIMENSION_TABLE_SHOW_SIZE);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    for (int i = 0; i < columns.length; i++) {
      getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
    }

    MainTableCellRenderer renderer = new MainTableCellRenderer();
    setDefaultRenderer(String.class, renderer);
    setComponentPopupMenu(popup);
  }

  @Override
  public JPopupMenu getComponentPopupMenu() {
    Point p = getMousePosition();
    if (p != null) {
      int row = rowAtPoint(p);
      if (isRowSelected(row)) {
        return super.getComponentPopupMenu();
      } else {
        return null;
      }
    }
    return super.getComponentPopupMenu();
  }

  @Override
  public void refresh() {
    int selectedRow = getSelectedRow();
    ((MainTableModel) getModel()).refresh();
    for (int i = 0; i < columns.length; i++) {
      getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
    }
    if (selectedRow != -1 && selectedRow < getRowCount()) {
      setRowSelectionInterval(selectedRow, selectedRow);
      requestFocus();
    }
    init();
  }

  protected void init() { }
}
