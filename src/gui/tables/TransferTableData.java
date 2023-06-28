package gui.tables;

import gui.renders.MainTableCellRenderer;
import gui.tables.models.TransferTableModel;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import settings.Text;
import settings.styles.ColorStyle;
import settings.styles.ImageIconStyle;

/**
 * The TransferTableData class represents the table data for transfers in the GUI.
 */
public class TransferTableData extends TableData {

  private static final String[] columns = new String[]{"DATE", "FROM_ACCOUNT", "TO_ACCOUNT",
    "FROM_AMOUNT", "TO_AMOUNT", "NOTICE"};
  private static final ImageIcon[] icons = new ImageIcon[]{
    ImageIconStyle.ICON_DATE, ImageIconStyle.ICON_ACCOUNT,
    ImageIconStyle.ICON_ACCOUNT, ImageIconStyle.ICON_AMOUNT,
    ImageIconStyle.ICON_AMOUNT, ImageIconStyle.ICON_NOTICE
  };

  public TransferTableData() {
    super(new TransferTableModel(columns), columns, icons);
    init();
  }

  @Override
  protected final void init() {
    getColumn(Text.get("FROM_AMOUNT"))
        .setCellRenderer(new TableCellAmountRenderer(ColorStyle.COLOR_EXP));
    getColumn(Text.get("TO_AMOUNT"))
        .setCellRenderer(new TableCellAmountRenderer(ColorStyle.COLOR_INCOME));
  }

  private static class TableCellAmountRenderer extends MainTableCellRenderer {

    private final Color color;

    public TableCellAmountRenderer(Color color) {
      this.color = color;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {
      Component renderer = super.getTableCellRendererComponent(table, value, isSelected,
          hasFocus, row, column);
      renderer.setForeground(color);
      return renderer;
    }
  }
}
