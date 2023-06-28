package gui;

import gui.menus.MainMenu;
import gui.panels.LeftPanel;
import gui.panels.RightPanel;
import gui.panels.TransferPanel;
import gui.toolbars.MainToolBar;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import settings.Text;
import settings.styles.BorderStyle;
import settings.styles.ImageIconStyle;

/**
 * The main frame of the GUI application.
 */
public final class MainFrame extends JFrame implements Refresh {

  private final GridBagConstraints constraints;
  private final MainMenu mb;
  private final LeftPanel leftPanel;
  private RightPanel rightPanel;
  private final MainToolBar tb;

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

    setRightPanel(new TransferPanel(this));

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

  /**
   * Sets the right panel of the main frame.
   * If there is an existing right panel, it is removed before adding the new panel.
   * The new panel is added to the main frame using the specified constraints.
   *
   * @param panel the right panel to be set
   */
  public void setRightPanel(RightPanel panel) {
    if (rightPanel != null) {
      remove(rightPanel);
    }
    constraints.gridy = 1;
    constraints.gridx = 1;
    rightPanel = panel;
    panel.setBorder(BorderStyle.BORDER_PANEL);
    add(rightPanel, constraints);
    pack();
  }

  public MainMenu getMenu() {
    return mb;
  }
}
