package gui.handlers;

import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The Handler class is an abstract class that serves
 * as a base for implementing action handlers in the GUI.
 */
public abstract class Handler implements ActionListener {

  protected final MainFrame frame;

  public Handler(MainFrame frame) {
    this.frame = frame;
  }

  @Override
  public void actionPerformed(ActionEvent ae) {
    frame.refresh();
  }
}
