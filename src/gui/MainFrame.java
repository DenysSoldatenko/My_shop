package gui;

import gui.menu.MainMenu;
import gui.toolbar.MainToolBar;
import settings.styles.ImageIconStyle;
import settings.Text;

import javax.swing.*;
import java.awt.*;

public final class MainFrame extends JFrame implements Refresh{

  private final GridBagConstraints constraints;
  private final MainMenu mb;
  private final MainToolBar tb;

  public MainFrame() {
    super(Text.get("PROGRAM_NAME"));
    setVisible(true);
    setResizable(false);
    setIconImage(ImageIconStyle.ICON_MAIN.getImage());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setResizable(false);
    setIconImage(ImageIconStyle.ICON_MAIN.getImage());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    mb = new MainMenu(this);
    setJMenuBar(mb);

    setLayout(new GridBagLayout());

    constraints = new GridBagConstraints();

    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 2;

    tb = new MainToolBar();
    add(tb, constraints);

    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.anchor = GridBagConstraints.NORTH;

    //add(new FunctionsToolBar(), constraints);
    add(new MainDatePicker().getDatePicker(), constraints);

    pack();
    setLocationRelativeTo(null);
  }

  @Override
  public void refresh() {
    System.out.println("1");
  }
}
