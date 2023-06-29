package gui.handlers;

import datastorages.SaveData;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import settings.HandlerCode;

/**
 * The FilterHandler class handles actions related to the filter in the GUI.
 */
public class FilterHandler extends Handler {
    
  public FilterHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    switch (ae.getActionCommand()) {
      case HandlerCode.LEFT -> SaveData.getInstance().getFilter().previous();
      case HandlerCode.RIGHT -> SaveData.getInstance().getFilter().next();
      case HandlerCode.STEP -> SaveData.getInstance().getFilter().nextPeriod();
      default -> {
        return;
      }
    }
    super.actionPerformed(ae);
  }
}
