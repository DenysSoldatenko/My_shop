package gui.handlers;

import gui.MainFrame;
import java.awt.event.ActionEvent;
import settings.HandlerCode;

/**
 * The MenuEditHandler class handles the action events for the menu edit options.
 */
public class MenuEditHandler extends Handler {

  public MenuEditHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    FunctionsHandler handler = frame.getRightPanel().getTableData().getHandler();
    switch (ae.getActionCommand()) {
      case HandlerCode.MENU_EDIT_ADD -> handler.add();
      case HandlerCode.MENU_EDIT_EDIT -> handler.edit();
      case HandlerCode.MENU_EDIT_DELETE -> handler.delete();
      default -> {
        return;
      }
    }
    super.actionPerformed(ae);
  }
}