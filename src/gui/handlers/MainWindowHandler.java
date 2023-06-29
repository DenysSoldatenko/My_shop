package gui.handlers;

import datastorages.SaveData;
import gui.MainFrame;
import gui.dialogs.ConfirmDialog;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;

/**
 * The MainWindowHandler class handles the window closing event of the main application window.
 */
public class MainWindowHandler extends WindowAdapter {
    
  @Override
  public void windowClosing(WindowEvent we) {
    if (SaveData.getInstance().isSaved()) {
      System.exit(0);
    } else {
      int result = ConfirmDialog.show((MainFrame) we.getWindow(),
          "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
      if (result == JOptionPane.YES_OPTION) {
        System.exit(0);
      }
    }
  }
}
