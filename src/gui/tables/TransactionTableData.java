package gui.tables;

import gui.renders.MainTableCellRenderer;
import gui.tables.models.TransactionTableModel;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import settings.Text;
import settings.styles.ColorStyle;
import settings.styles.ImageIconStyle;

/**
 * The TransactionTableData class represents the table data for transactions in the GUI.
 */
public class TransactionTableData extends TableData {

  private static final String[] columns = new String[]{
    "DATE", "ACCOUNT",
    "ARTICLE", "AMOUNT", "NOTICE"};
  private static final ImageIcon[] icons = new ImageIcon[]{
    ImageIconStyle.ICON_DATE, ImageIconStyle.ICON_ACCOUNT,
    ImageIconStyle.ICON_ARTICLE, ImageIconStyle.ICON_AMOUNT,
    ImageIconStyle.ICON_NOTICE};

  public TransactionTableData() {
    super(new TransactionTableModel(columns), columns, icons);
    init();
  }

  public TransactionTableData(int count) {
    super(new TransactionTableModel(columns, count), columns, icons);
    init();
  }

  @Override
  protected final void init() {
    getColumn(Text.get("AMOUNT")).setCellRenderer(new TableCellAmountRenderer());
  }

  private static class TableCellAmountRenderer extends MainTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
      Component renderer = super.getTableCellRendererComponent(table, value, isSelected,
          hasFocus, row, column);
      if ((value.toString()).contains("-")) {
        renderer.setForeground(ColorStyle.COLOR_EXP);
      } else {
        renderer.setForeground(ColorStyle.COLOR_INCOME);
      }
      return renderer;
    }
  }
}
