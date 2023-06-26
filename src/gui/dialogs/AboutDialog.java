package gui.dialogs;

import javax.swing.JDialog;
import javax.swing.JEditorPane;
import settings.Text;
import settings.styles.ImageIconStyle;

/**
 * A dialog box that displays information about the application.
 */
public class AboutDialog extends JDialog {

  /**
   * Constructs an instance of the AboutDialog.
   * Initializes the dialog's title, icon, and resizable property.
   */
  public AboutDialog() {
    super();
    init();
    setTitle(Text.get("DIALOG_ABOUT_TITLE"));
    setIconImage(ImageIconStyle.ICON_ABOUT.getImage());
    setResizable(false);
  }

  private void init() {
    JEditorPane pane = new JEditorPane("text/html", Text.get("ABOUT"));
    pane.setEditable(false);
    pane.setOpaque(false);
    add(pane);
    pack();
    setLocationRelativeTo(null);
  }
}
