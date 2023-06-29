package gui.handlers;

import gui.MainFrame;
import java.awt.event.ActionEvent;
import settings.HandlerCode;
import settings.Settings;
import settings.Text;

/**
 * The MenuSettingsHandler class handles the actions related to the settings menu in the GUI.
 */
public class MenuSettingsHandler extends Handler {

  public MenuSettingsHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    switch (ae.getActionCommand()) {
      case HandlerCode.MENU_SETTINGS_LANGUAGE_UKRAINIAN -> Settings.setLanguage("uk");
      case HandlerCode.MENU_SETTINGS_LANGUAGE_ENGLISH -> Settings.setLanguage("en");
      default -> {
        return;
      }
    }
    Text.init();
    frame.getMenu().refresh();
    super.actionPerformed(ae);
  }
}

