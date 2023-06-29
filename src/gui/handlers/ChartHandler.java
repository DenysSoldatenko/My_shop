package gui.handlers;

import gui.MainFrame;
import gui.panels.StatisticsPanel;
import java.awt.event.ActionEvent;
import settings.HandlerCode;

/**
 * The ChartHandler class handles actions related to the chart in the GUI.
 */
public class ChartHandler extends Handler {
    
  public ChartHandler(MainFrame frame) {
    super(frame);
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    if (ae.getActionCommand().equals(HandlerCode.TYPE)) {
      ((StatisticsPanel) frame.getRightPanel()).nextType();
    }
    super.actionPerformed(ae);
  }
}
