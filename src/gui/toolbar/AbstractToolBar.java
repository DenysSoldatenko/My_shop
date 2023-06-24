package gui.toolbar;

import gui.MainButton;
import gui.Refresh;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public abstract class AbstractToolBar extends JPanel implements Refresh {

  public AbstractToolBar() {

  }

  protected abstract void init();

  protected MainButton addButton(String title, ImageIcon icon, String action, boolean topIcon) {
    MainButton button = new MainButton(title, icon, null, action);
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


