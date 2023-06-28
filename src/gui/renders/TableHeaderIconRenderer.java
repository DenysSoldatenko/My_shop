package gui.renders;

import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 * The TableHeaderIconRenderer class represents a custom renderer for table headers with an icon.
 */
public class TableHeaderIconRenderer extends DefaultTableCellRenderer {

  private final JLabel label;

  public TableHeaderIconRenderer(ImageIcon icon) {
    super();
    label = new JLabel(icon);
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                 boolean hasFocus, int row, int column) {
    TableCellRenderer tcr = table.getTableHeader().getDefaultRenderer();
    Component renderer = tcr.getTableCellRendererComponent(table, value, isSelected,
        hasFocus, row, column);
    label.setFont(renderer.getFont());
    label.setForeground(renderer.getForeground());
    label.setBorder(((JComponent) renderer).getBorder());
    label.setText(String.valueOf(value));
    return label;
  }
}
