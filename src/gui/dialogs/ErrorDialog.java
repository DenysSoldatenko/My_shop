package gui.dialogs;

import gui.MainFrame;
import javax.swing.JOptionPane;
import settings.Text;

/**
 * A dialog for displaying error messages in the GUI.
 */
public class ErrorDialog {

  public static void show(MainFrame frame, String text) {
    JOptionPane.showMessageDialog(frame, Text.get(text),
        Text.get("ERROR"), JOptionPane.ERROR_MESSAGE);
  }
}
