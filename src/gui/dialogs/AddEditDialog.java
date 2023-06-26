package gui.dialogs;

import gui.MainButton;
import gui.MainFrame;
import java.awt.BorderLayout;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import lombok.Getter;
import lombok.Setter;
import models.Common;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import settings.HandlerCode;
import settings.Text;
import settings.exceptions.ModelException;
import settings.styles.BorderStyle;
import settings.styles.ConstantStyle;
import settings.styles.DimensionStyle;
import settings.styles.FontStyle;
import settings.styles.ImageIconStyle;

@Getter
@Setter
public abstract class AddEditDialog extends JDialog {

  private final MainFrame frame;
  protected LinkedHashMap<String, JComponent> elements = new LinkedHashMap<>();
  protected LinkedHashMap<String, ImageIcon> icons = new LinkedHashMap<>();
  protected LinkedHashMap<String, Object> values = new LinkedHashMap<>();
  protected Common common;

  public AddEditDialog(MainFrame frame) {
    super(frame, Text.get("ADD"), true);
    this.frame = frame;
    setResizable(false);
  }

  public boolean isAdd() {
    return common == null;
  }

  public abstract Common getCommonFromForm() throws ModelException;

  protected abstract void init();

  protected abstract void setValues();

  private void setDialog() {
    init();
    if (isAdd()) {
      setTitle(Text.get("ADD"));
      setIconImage(ImageIconStyle.ICON_ADD.getImage());
    } else {
      setValues();
      setTitle(Text.get("EDIT"));
      setIconImage(ImageIconStyle.ICON_EDIT.getImage());
    }
    getContentPane().removeAll();
    getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
    ((JPanel) getContentPane()).setBorder(BorderStyle.BORDER_DIALOG);
    addComponents();
    addButtons();
    pack();
    setLocationRelativeTo(null);
  }

  private void addComponents() {
    for (Map.Entry<String, JComponent> entry : elements.entrySet()) {
      String key = entry.getKey();
      JLabel label = new JLabel(Text.get(key));
      label.setIcon(icons.get(key));
      label.setFont(FontStyle.FONT_DIALOG_LABEL);

      JComponent component = entry.getValue();
      if (component instanceof JTextField) {
        component.setPreferredSize(DimensionStyle.DIMENSION_DIALOG_TEXT_FIELD_SIZE);
        if (values.containsKey(key)) {
          ((JTextField) component).setText(String.valueOf(values.get(key)));
        }
      } else if (component instanceof JComboBox) {
        if (values.containsKey(key)) {
          ((JComboBox<?>) component).setSelectedItem(values.get(key));
        }
      } else if (component instanceof JDatePickerImpl) {
        if (values.containsKey(key)) {
          ((UtilDateModel) ((JDatePickerImpl) component)
          .getModel()).setValue((Date) values.get(key));
        }
      }
      component.setAlignmentX(JComponent.LEFT_ALIGNMENT);
      add(label);
      add(Box.createVerticalStrut(ConstantStyle.PADDING_DIALOG));
      add(component);
      add(Box.createVerticalStrut(ConstantStyle.PADDING_DIALOG));
    }
  }

  private void addButtons() {
    MainButton ok = new MainButton(Text.get("ADD"), ImageIconStyle.ICON_OK, null, HandlerCode.ADD);
    if (!isAdd()) {
      ok.setActionCommand(HandlerCode.EDIT);
      ok.setText(Text.get("EDIT"));
    }

    MainButton cancel = new MainButton(Text.get("CANCEL"), ImageIconStyle.ICON_CANCEL,
        null, HandlerCode.CANCEL);

    JPanel panelButtons = new JPanel();
    panelButtons.setLayout(new BorderLayout());
    panelButtons.setAlignmentX(JPanel.LEFT_ALIGNMENT);
    panelButtons.add(ok, BorderLayout.WEST);
    panelButtons.add(Box.createRigidArea(DimensionStyle.DIMENSION_DIALOG_PADDING_BUTTON),
        BorderLayout.CENTER);
    panelButtons.add(cancel, BorderLayout.EAST);

    add(panelButtons);
  }

  public final void showDialog() {
    setDialog();
    setVisible(true);
  }

  public final void closeDialog() {
    setVisible(false);
    this.common = null;
    elements.clear();
    icons.clear();
    values.clear();
    dispose();
  }
}
