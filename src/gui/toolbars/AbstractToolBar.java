package gui.toolbars;

import gui.MainButton;
import gui.handlers.Handler;
import gui.interfaces.Refresh;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * The AbstractToolBar class represents an abstract toolbar in the GUI.
 */
public abstract class AbstractToolBar extends JPanel implements Refresh {

  private final Handler handler;

  /**
   * Constructs an AbstractToolBar with the specified empty border and handler.
   *
   * @param border  the empty border for the toolbar
   * @param handler the handler for toolbar actions
   */
  public AbstractToolBar(EmptyBorder border, Handler handler) {
    super();
    this.handler = handler;
    setBorder(border);
  }

  protected abstract void init();

  protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
    MainButton button = new MainButton(title, icon, handler, action);
    if (topIcon) {
      button.setHorizontalTextPosition(SwingConstants.CENTER);
      button.setVerticalTextPosition(SwingConstants.BOTTOM);
    } else {
      button.setHorizontalTextPosition(SwingConstants.RIGHT);
      button.setVerticalTextPosition(SwingConstants.CENTER);
    }
    add(button);
    return button;
  }

  @Override
  public void refresh() {
    removeAll();
    init();
  }
}


