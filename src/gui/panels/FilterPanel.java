package gui.panels;

import datastorages.SaveData;
import gui.MainButton;
import gui.MainFrame;
import java.awt.Dimension;
import java.awt.FlowLayout;
import settings.Format;
import settings.HandlerCode;
import settings.styles.BorderStyle;
import settings.styles.ConstantStyle;
import settings.styles.FontStyle;
import settings.styles.ImageIconStyle;

/**
 * The FilterPanel class represents a panel that displays filter options and navigation buttons.
 */
public final class FilterPanel extends AbstractPanel {

  public FilterPanel(MainFrame frame) {
    super(frame);
    init();
  }

  @Override
  protected void init() {
    FlowLayout layout = new FlowLayout();
    layout.setVgap(0);
    setLayout(layout);
    MainButton left = new MainButton(ImageIconStyle.ICON_LEFT, null, HandlerCode.LEFT);
    add(left);
    MainButton step = new MainButton(Format.getTitleFilter(SaveData.getInstance().getFilter()),
        null, HandlerCode.STEP);
    step.setFont(FontStyle.FONT_BUTTON_FILTER);
    step.setPreferredSize(new Dimension(ConstantStyle.WIDTH_FILTER_BUTTON,
        left.getPreferredSize().height));
    add(step);
    MainButton right = new MainButton(ImageIconStyle.ICON_RIGHT, null, HandlerCode.RIGHT);
    add(right);

    setBorder(BorderStyle.BORDER_FILTER_PANEL);
  }
}
