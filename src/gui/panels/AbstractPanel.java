package gui.panels;

import gui.MainFrame;
import gui.interfaces.Refresh;
import javax.swing.JPanel;

/**
 * The AbstractPanel class represents a base panel for GUI panels in the application.
 */
public abstract class AbstractPanel extends JPanel implements Refresh {

  protected final MainFrame frame;

  public AbstractPanel(MainFrame frame) {
    this.frame = frame;
  }

  @Override
  public void refresh() {
    removeAll();
    init();
  }

  protected abstract void init();
}
