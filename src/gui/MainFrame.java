package gui;

import gui.handlers.MainToolBarHandler;
import gui.handlers.MainWindowHandler;
import gui.interfaces.Refresh;
import gui.menus.MainMenu;
import gui.panels.LeftPanel;
import gui.panels.RightPanel;
import gui.panels.models.TransactionPanel;
import gui.toolbars.MainToolBar;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import lombok.Getter;
import settings.Text;
import settings.styles.BorderStyle;
import settings.styles.ImageIconStyle;

/**
 * The main frame of the GUI application.
 */
@Getter
public final class MainFrame extends JFrame implements Refresh {

  private final GridBagConstraints constraints;
  private final MainMenu menu;
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
    setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

    menu = new MainMenu(this);
    setJMenuBar(menu);

    setLayout(new GridBagLayout());

    constraints = new GridBagConstraints();

    constraints.gridx = 0;
    constraints.gridy = 0;
    constraints.gridwidth = 2;

    tb = new MainToolBar(new MainToolBarHandler(this));
    add(tb, constraints);

    constraints.gridy = 1;
    constraints.gridwidth = 1;
    constraints.anchor = GridBagConstraints.NORTH;

    leftPanel = new LeftPanel(this);
    add(leftPanel, constraints);

    setRightPanel(new TransactionPanel(this));

    pack();
    setLocationRelativeTo(null);

    addWindowListener(new MainWindowHandler());
  }

  @Override
  public void refresh() {
    SwingUtilities.updateComponentTreeUI(this);
    tb.refresh();
    leftPanel.refresh();
    rightPanel.refresh();
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
}
