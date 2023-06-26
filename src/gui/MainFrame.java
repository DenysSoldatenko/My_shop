package gui;

import datastorages.SaveData;
import gui.dialogs.CurrencyAddEditDialog;
import gui.menus.MainMenu;
import gui.toolbars.MainToolBar;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import settings.Text;
import settings.styles.ImageIconStyle;

/**
 * The main frame of the GUI application.
 */
public final class MainFrame extends JFrame implements Refresh {

  private final GridBagConstraints constraints;
  private final MainMenu mb;
  private final MainToolBar tb;

  /**
   * Constructs a new instance of the MainFrame.
   * Initializes the frame and sets up the main elements.
   */
  public MainFrame() {
    super(Text.get("PROGRAM_NAME"));

    CurrencyAddEditDialog currencyAddEditDialog = new CurrencyAddEditDialog(this);
    currencyAddEditDialog.setCommon(SaveData.getInstance().getBaseCurrency());
    currencyAddEditDialog.showDialog();

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
