package gui;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import settings.styles.ColorStyle;
import settings.styles.FontStyle;

/**
 * A custom JButton with styles and hover effect for the main GUI buttons.
 */
public class MainButton extends JButton {

  /**
   * Constructs a MainButton with the specified title, icon, action listener, and action command.
   *
   * @param title the button's title
   * @param icon the button's icon
   * @param listener the action listener for the button
   * @param action the action command for the button
   */
  public MainButton(String title, ImageIcon icon, ActionListener listener, String action) {
    super(title);
    setIcon(icon);
    setActionCommand(action);
    addActionListener(listener);
    addMouseListener(new HoverButton());

    setFont(FontStyle.FONT_MAIN_BUTTON);
    setFocusPainted(false);
    setBackground(ColorStyle.COLOR_BUTTON_BG_NORMAL);
  }

  public MainButton(String title, ActionListener listener, String action) {
    this(title, null, listener, action);
  }

  public MainButton(ImageIcon icon, ActionListener listener, String action) {
    this("", icon, listener, action);
  }

  private static class HoverButton implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {}

    @Override
    public void mousePressed(MouseEvent me) {}

    @Override
    public void mouseReleased(MouseEvent me) {}

    @Override
    public void mouseEntered(MouseEvent me) {
      ((MainButton) me.getSource()).setBackground(ColorStyle.COLOR_BUTTON_BG_HOVER);
    }

    @Override
    public void mouseExited(MouseEvent me) {
      ((MainButton) me.getSource()).setBackground(ColorStyle.COLOR_BUTTON_BG_NORMAL);
    }
  }
}
