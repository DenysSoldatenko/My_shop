package gui.dialogs;

import gui.MainFrame;
import javax.swing.JOptionPane;
import settings.Text;

/**
 * A dialog for displaying a confirmation message with Yes/No options in the GUI.
 */
public class ConfirmDialog {

  /**
   * Shows a confirmation dialog with the specified message and title.
   *
   * @param frame the main frame of the GUI
   * @param text the message to display
   * @param title the title of the dialog
   * @return an integer representing the user's choice (0 for "Yes", 1 for "No")
   */
  public static int show(MainFrame frame, String text, String title) {
    String[] options = {Text.get("YES"), Text.get("NO")};
    return JOptionPane.showOptionDialog(frame, Text.get(text),
    Text.get(title), JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE,
    null, options, options[1]);
  }
}
