package gui.panels;

import gui.MainFrame;
import gui.interfaces.EnableEditDelete;
import gui.interfaces.Refresh;
import gui.tables.TableData;
import gui.toolbars.AbstractToolBar;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import lombok.Setter;
import settings.Text;
import settings.styles.ConstantStyle;
import settings.styles.FontStyle;

/**
 * The RightPanel class represents a panel on the right side of the main frame.
 */
@Setter
public abstract class RightPanel extends AbstractPanel {

  protected TableData td;
  private String title;
  private ImageIcon icon;
  private JPanel[] panels;

  /**
   * Constructs a RightPanel with the specified MainFrame,
   * TableData, title, icon, and panels.
   *
   * @param frame   the MainFrame to associate with the panel
   * @param td      the TableData to display in the panel
   * @param title   the title of the panel
   * @param icon    the icon for the panel
   * @param panels  an array of JPanels to add to the panel
   */
  public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon, JPanel[] panels) {
    super(frame);
    this.td = td;
    this.title = title;
    this.icon = icon;
    this.panels = panels;
    init();
  }

  public RightPanel(MainFrame fm, TableData td, String title, ImageIcon icon, AbstractToolBar tb) {
    this(fm, td, title, icon, new JPanel[]{tb});
  }

  public RightPanel(MainFrame frame, TableData td, String title, ImageIcon icon) {
    this(frame, td, title, icon, new JPanel[]{});
  }

  @Override
  public void refresh() {
    super.refresh();
    if (td != null) {
      td.refresh();
    }
    for (JPanel panel : panels) {
      if (panel instanceof Refresh) {
        ((Refresh) panel).refresh();
      }
    }
  }

  private void enableEditDelete() {
    for (JPanel panel : panels) {
      if (panel instanceof EnableEditDelete) {
        ((EnableEditDelete) panel).setEnableEditDelete(false);
      }
    }
    frame.getMenu().setEnableEditDelete(false);

    if (td != null) {
      if (td.getSelectedRow() != -1) {
        for (JPanel panel : panels) {
          if (panel instanceof EnableEditDelete) {
            ((EnableEditDelete) panel).setEnableEditDelete(true);
          }
        }
        frame.getMenu().setEnableEditDelete(true);
      }
    }
  }

  @Override
  protected final void init() {
    enableEditDelete();
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    JLabel header = new JLabel(Text.get(title));
    header.setFont(FontStyle.FONT_LABEL_HEADER);
    header.setIcon(icon);
    header.setAlignmentX(JLabel.CENTER_ALIGNMENT);
    add(header);

    if (panels.length == 0) {
      add(Box.createVerticalStrut(ConstantStyle.PADDING_PANEL_EMPTY));
    }

    for (JPanel panel : panels) {
      add(panel);
      add(Box.createVerticalStrut(ConstantStyle.PADDING_PANEL));
    }

    if (td != null) {
      JScrollPane scroll = new JScrollPane(td);
      add(scroll);
      scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
      ListSelectionModel selectionModel = td.getSelectionModel();
      selectionModel.addListSelectionListener(lse -> enableEditDelete());
    }
  }

  public TableData getTableData() {
    return td;
  }
}
