package gui;

import gui.menus.MainMenu;
import gui.panels.LeftPanel;
import gui.toolbars.MainToolBar;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import settings.Text;
import settings.styles.ImageIconStyle;

/**
 * The main frame of the GUI application.
 */
public final class MainFrame extends JFrame implements Refresh {

  private final GridBagConstraints constraints;
  private final MainMenu mb;
  private final MainToolBar tb;
  private final LeftPanel leftPanel;

  /**
   * Constructs a new instance of the MainFrame.
   * Initializes the frame and sets up the main elements.
   */
  public MainFrame() {
    super(Text.get("PROGRAM_NAME"));

    setVisible(true);
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

    leftPanel = new LeftPanel(this);
    add(leftPanel, constraints);

    pack();
    setLocationRelativeTo(null);
  }

  @Override
  public void refresh() {
    SwingUtilities.updateComponentTreeUI(this);
    tb.refresh();
    leftPanel.refresh();
    pack();
  }
}
