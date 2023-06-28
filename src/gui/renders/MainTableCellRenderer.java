package gui.renders;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

/**
 * The MainTableCellRenderer class is a custom cell renderer that
 * renders table cells with centered alignment.
 */
public class MainTableCellRenderer extends DefaultTableCellRenderer {

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {
    super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
    setBorder(noFocusBorder);
    setHorizontalAlignment(SwingConstants.CENTER);
    return this;
  }
}
