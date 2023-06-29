package gui.handlers;

import datastorages.SaveData;
import gui.MainFileChooser;
import gui.MainFrame;
import gui.dialogs.ConfirmDialog;
import gui.dialogs.ErrorDialog;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import settings.HandlerCode;
import settings.Settings;

/**
 * The MenuFileHandler class handles file-related actions in the menu.
 */
public class MenuFileHandler extends Handler {

  private final MainFileChooser fc;

  public MenuFileHandler(MainFrame frame) {
    super(frame);
    fc = new MainFileChooser(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    switch (ae.getActionCommand()) {

      case HandlerCode.MENU_FILE_NEW -> {
        Settings.setFileSave(null);
        SaveData.getInstance().clear();
      }

      case HandlerCode.MENU_FILE_OPEN -> {
        int result = fc.open();
        if (result == JFileChooser.APPROVE_OPTION) {
          Settings.setFileSave(fc.getSelectedFile());
          SaveData.getInstance().clear();
          SaveData.getInstance().load();
        }
      }

      case HandlerCode.MENU_FILE_SAVE -> {
        if (Settings.getFileSave() == null) {
          int result = fc.save();
          if (result == JFileChooser.APPROVE_OPTION) {
            String path = fc.getSelectedFile().getAbsolutePath();
            String ext = path.substring(path.lastIndexOf(".") + 1);
            if (ext.equals(Settings.SAVE_FILE_EXTENSION)) {
              Settings.setFileSave(new File(path));
            } else {
              Settings.setFileSave(new File(path + "." + Settings.SAVE_FILE_EXTENSION));
            }
          }
        }
        if (Settings.getFileSave() != null) {
          SaveData.getInstance().save();
        }
      }

      case HandlerCode.MENU_FILE_UPDATE_CURRENCIES -> {
        try {
          SaveData.getInstance().updateCurrencies();
        } catch (Exception ex) {
          ErrorDialog.show(frame, "ERROR_UPDATE_CURRENCIES");
        }
      }

      case HandlerCode.MENU_FILE_EXIT -> {
        if (SaveData.getInstance().isSaved()) {
          System.exit(0);
        } else {
          int result = ConfirmDialog.show(frame, "CONFIRM_EXIT_TEXT", "CONFIRM_EXIT_TITLE");
          if (result == JOptionPane.YES_OPTION) {
            System.exit(0);
          }
        }
      }

      default -> {
        return;
      }
    }
    super.actionPerformed(ae);
  }
}
