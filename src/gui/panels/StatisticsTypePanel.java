package gui.panels;

import gui.MainButton;
import gui.MainFrame;
import gui.handlers.ChartHandler;
import settings.HandlerCode;
import settings.Text;

/**
 * The StatisticsTypePanel class represents a panel
 * for selecting the type of statistics.
 */
public final class StatisticsTypePanel extends AbstractPanel {

  private final String title;

  /**
   * Constructs a StatisticsTypePanel with the specified frame and title.
   *
   * @param frame the main frame
   * @param title the title of the panel
   */
  public StatisticsTypePanel(MainFrame frame, String title) {
    super(frame);
    this.title = Text.get(title);
    init();
  }

  @Override
  protected void init() {
    MainButton type = new MainButton(title, new ChartHandler(frame), HandlerCode.TYPE);
    add(type);
  }
}
