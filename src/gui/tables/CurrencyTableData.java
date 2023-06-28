package gui.tables;

import gui.renders.MainTableCellRenderer;
import gui.tables.models.CurrencyTableModel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import models.Currency;
import settings.Text;
import settings.styles.ColorStyle;
import settings.styles.ImageIconStyle;

/**
 * The CurrencyTableData class represents the table data for currencies in the GUI.
 */
public class CurrencyTableData extends TableData {

  private static final String[] columns = new String[]{"TITLE", "CODE", "RATE", "ON", "BASE"};
  private static final ImageIcon[] icons = new ImageIcon[]{
    ImageIconStyle.ICON_TITLE, ImageIconStyle.ICON_CODE,
    ImageIconStyle.ICON_RATE, ImageIconStyle.ICON_ON, ImageIconStyle.ICON_BASE
  };

  public CurrencyTableData() {
    super(new CurrencyTableModel(columns), columns, icons);
    init();
  }

  @Override
  protected final void init() {
    for (String column : columns) {
      getColumn(Text.get(column)).setCellRenderer(new TableCellOnOffRenderer());
    }
  }

  private static class TableCellOnOffRenderer extends MainTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
      Component renderer = super.getTableCellRendererComponent(table, value, isSelected,
          hasFocus, row, column);
      if (((Currency) ((CurrencyTableModel) table.getModel()).getCommonByRow(row)).isOn()) {
        renderer.setForeground(ColorStyle.COLOR_ON);
      } else {
        renderer.setForeground(ColorStyle.COLOR_OFF);
      }
      return renderer;
    }
  }
}
