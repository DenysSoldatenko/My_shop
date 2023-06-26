package gui.dialogs;

import gui.MainFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import settings.Text;

/**
 * A dialog for displaying a confirmation message with Yes/No options in the GUI.
 */
public class ConfirmDialog {

  /**
   * Displays a confirmation dialog with the specified message and title.
   *
   * @param frame the main frame of the GUI
   * @param text the confirmation message text key
   * @param title the title of the confirmation dialog
   * @return the option selected by the user (JOptionPane.YES_OPTION or JOptionPane.NO_OPTION)
   */
  public static int show(MainFrame frame, String text, String title) {
    String[] options = {Text.get("YES"), Text.get("NO")};
    JButton[] buttons = new JButton[options.length];
    for (int i = 0; i < options.length; i++) {
      buttons[i] = new JButton(options[i]);
      buttons[i].setFocusable(false); // Remove focusability
    }

    return JOptionPane.showOptionDialog(frame, Text.get(text), Text.get(title),
    JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null,
    buttons, buttons[1]);
  }
}
