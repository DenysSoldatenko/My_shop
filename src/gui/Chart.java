package gui;

import java.awt.GridBagLayout;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieToolTipGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import settings.Text;
import settings.styles.DimensionStyle;
import settings.styles.FontStyle;

/**
 * The Chart class represents a pie chart visualization.
 */
public final class Chart {

  private DefaultPieDataset dataset;
  private final String title;
  private final String currencyTitle;

  /**
   * Constructs a Chart object.
   *
   * @param data          the data for the chart
   * @param title         the title of the chart
   * @param currencyTitle the title of the currency
   */
  public Chart(HashMap<String, Double> data, String title, String currencyTitle) {
    setData(data);
    this.title = Text.get(title);
    this.currencyTitle = currencyTitle;
  }

  private void setData(HashMap<String, Double> data) {
    dataset = new DefaultPieDataset();
    for (Map.Entry<String, Double> entry : data.entrySet()) {
      dataset.setValue(entry.getKey(), entry.getValue());
    }
  }

  /**
   * Returns a JPanel containing the pie chart visualization.
   *
   * @return the JPanel containing the pie chart
   */
  public JPanel getPanel() {
    JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);
    PiePlot plot = (PiePlot) chart.getPlot();
    plot.setToolTipGenerator(
      new StandardPieToolTipGenerator("{0}: {1} " + currencyTitle + " ({2})")
    );
    JPanel panel = new ChartPanel(chart);
    panel.setPreferredSize(DimensionStyle.DIMENSION_CHART);
    if (dataset.getItemCount() == 0) {
      panel.setLayout(new GridBagLayout());
      JLabel label = new JLabel(Text.get("CHART_NO_DATA"));
      label.setFont(FontStyle.FONT_LABEL_HEADER);
      panel.add(label);
    }
    return panel;
  }
}
