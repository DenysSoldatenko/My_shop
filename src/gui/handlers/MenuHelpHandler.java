package gui.handlers;

import gui.MainFrame;
import gui.dialogs.AboutDialog;
import java.awt.event.ActionEvent;
import settings.HandlerCode;

/**
 * The MenuHelpHandler class handles the action events for the menu help option.
 */
public class MenuHelpHandler extends Handler {

  public MenuHelpHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getActionCommand().equals(HandlerCode.MENU_HELP_ABOUT)) {
      new AboutDialog().setVisible(true);
    }
    super.actionPerformed(ae);
  }
}