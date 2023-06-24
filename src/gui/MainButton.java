package gui;

import settings.styles.ColorStyle;
import settings.styles.FontStyle;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MainButton extends JButton {

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
