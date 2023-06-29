package gui.tables;

import gui.handlers.FunctionsHandler;
import gui.interfaces.Refresh;
import gui.menus.TablePopupMenu;
import gui.renders.MainTableCellRenderer;
import gui.renders.TableHeaderIconRenderer;
import gui.tables.models.MainTableModel;
import java.awt.Point;
import javax.swing.ImageIcon;
import javax.swing.JPopupMenu;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import lombok.Getter;
import settings.Text;
import settings.styles.ConstantStyle;
import settings.styles.DimensionStyle;
import settings.styles.FontStyle;

/**
 * The TableData class represents a table in the GUI.
 */
@Getter
public abstract class TableData extends JTable implements Refresh {

  private final FunctionsHandler handler;
  private final String[] columns;
  private final ImageIcon[] icons;

  /**
   * Constructs a TableData with the specified model,
   * handler, columns, and icons.
   *
   * @param model   the table model
   * @param handler the function handler
   * @param columns the column names
   * @param icons   the icons for column headers
   */
  public TableData(MainTableModel model, FunctionsHandler handler,
                   String[] columns, ImageIcon[] icons
  ) {
    super(model);
    this.handler = handler;
    this.columns = columns;
    this.icons = icons;
    TablePopupMenu popup = new TablePopupMenu(handler);
    setComponentPopupMenu(popup);

    getTableHeader().setFont(FontStyle.FONT_TABLE_HEADER);
    setFont(FontStyle.FONT_TABLE);
    setRowHeight(getRowHeight() + ConstantStyle.TABLE_ADD_ROW_HEIGHT);

    setAutoCreateRowSorter(true);
    setPreferredScrollableViewportSize(DimensionStyle.DIMENSION_TABLE_SHOW_SIZE);
    setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    addMouseListener(handler);
    addKeyListener(handler);

    for (int i = 0; i < columns.length; i++) {
      getColumn(Text.get(columns[i])).setHeaderRenderer(new TableHeaderIconRenderer(icons[i]));
    }

    MainTableCellRenderer renderer = new MainTableCellRenderer();
    setDefaultRenderer(String.class, renderer);
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
