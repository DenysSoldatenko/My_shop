package gui.panels;

import datastorages.SaveData;
import gui.MainFrame;
import java.awt.BorderLayout;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Currency;
import models.Statistics;
import settings.Format;
import settings.Text;
import settings.styles.BorderStyle;
import settings.styles.ColorStyle;
import settings.styles.ConstantStyle;
import settings.styles.DimensionStyle;
import settings.styles.FontStyle;
import settings.styles.ImageIconStyle;

/**
 * The LeftPanel class represents a panel on the left side of the application's main frame.
 * It displays balance currencies and their corresponding balances.
 */
public final class LeftPanel extends AbstractPanel {

  public LeftPanel(MainFrame frame) {
    super(frame);
    init();
  }

  @Override
  protected void init() {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBorder(BorderStyle.BORDER_LEFT_PANEL);
    JLabel balanceCurrencyHeader = new JLabel(Text.get("BALANCE_CURRENCIES"));
    balanceCurrencyHeader.setFont(FontStyle.FONT_LABEL_HEADER);
    balanceCurrencyHeader.setIcon(ImageIconStyle.ICON_LEFT_PANEL_BALANCE_CURRENCIES);
    balanceCurrencyHeader.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    add(balanceCurrencyHeader);

    addBalanceCurrency();

    add(Box.createVerticalStrut(ConstantStyle.PADDING_PANEL_BIG));

    JLabel headerB = new JLabel(Text.get("BALANCE"));
    headerB.setFont(FontStyle.FONT_LABEL_HEADER);
    headerB.setIcon(ImageIconStyle.ICON_LEFT_PANEL_BALANCE);
    headerB.setAlignmentX(JComponent.CENTER_ALIGNMENT);
    add(headerB);

    addBalance();
  }

  private void addBalanceCurrency() {
    for (Currency currency : SaveData.getInstance().getEnableCurrencies()) {
      add(Box.createVerticalStrut(ConstantStyle.PADDING_BALANCE));
      add(new PanelBalanceCurrency(currency, Statistics.getBalanceCurrency(currency)));
    }
  }

  private void addBalance() {
    for (Currency currency : SaveData.getInstance().getEnableCurrencies()) {
      add(Box.createVerticalStrut(ConstantStyle.PADDING_BALANCE));
      add(new PanelBalanceCurrency(currency, Statistics.getBalance(currency)));
    }
  }

  private static class PanelBalanceCurrency extends JPanel {

    public PanelBalanceCurrency(Currency currency, double amount) {
      super();
      setLayout(new BorderLayout());
      setBackground(ColorStyle.COLOR_LEFT_PANEL_BALANCE);
      setBorder(BorderStyle.BORDER_PANEL);

      JLabel currencyLabel = new JLabel(currency.getTitle());
      JLabel amountLabel = new JLabel(Format.amount(amount, currency));

      currencyLabel.setFont(FontStyle.FONT_LABEL_LEFT_PANEL_CURRENCY);
      amountLabel.setFont(FontStyle.FONT_LABEL_LEFT_PANEL_AMOUNT);

      add(currencyLabel, BorderLayout.WEST);
      add(Box.createRigidArea(DimensionStyle.DIMENSION_PADDING_BALANCE));
      add(amountLabel, BorderLayout.EAST);
    }
  }
}
