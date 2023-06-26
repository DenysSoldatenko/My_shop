package gui.dialogs;

import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JComboBox;
import javax.swing.JList;
import models.Common;

/**
 * A custom JComboBox that accepts an array of Common objects
 * and renders them using a custom renderer.
 */
public class CommonComboBox extends JComboBox<Common> {

  /**
   * Constructs a CommonComboBox with the specified array of Common objects.
   *
   * @param objs the array of Common objects to be displayed in the ComboBox.
   */
  public CommonComboBox(Common[] objs) {
    super(objs);
    setRenderer(new DefaultListCellRenderer() {
      @Override
      public Component getListCellRendererComponent(JList list, Object value, int index,
                                                    boolean isSelected, boolean cellHasFocus) {
        DefaultListCellRenderer renderer
               = (DefaultListCellRenderer) super.getListCellRendererComponent(list, value, index,
               isSelected, cellHasFocus);
        Common c = (Common) value;
        if (c != null) {
          renderer.setText(c.getValueForComboBox());
        }
        return renderer;
      }
    });
  }
}
