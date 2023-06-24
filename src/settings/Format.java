package settings;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import models.Currency;
import models.Filter;

/**
 * The Format class provides utility methods for formatting data values
 * according to specific formats. It includes methods for formatting amounts, rates, dates,
 * and other values used in the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Format {

  public static String amount(final double amount) {
    return String.format(Settings.FORMAT_AMOUNT, amount);
  }

  public static String amount(final double amount, final Currency currency) {
    return amount(amount) + " " + currency.getCode();
  }

  public static String rate(final double rate) {
    return String.format(Settings.FORMAT_RATE, rate);
  }

  public static String rate(final double rate, final Currency currency) {
    return rate(rate) + " " + currency.getCode();
  }

  public static String date(final Date date) {
    return dateFormat(date, Settings.FORMAT_DATE);
  }

  public static String dateMonth(final Date date) {
    return dateFormat(date, Settings.FORMAT_DATE_MONTH);
  }

  public static String dateYear(final Date date) {
    return dateFormat(date, Settings.FORMAT_DATE_YEAR);
  }

  private static String dateFormat(final Date date, final String format) {
    SimpleDateFormat sdf =
        new SimpleDateFormat(format, new MainDateFormat());
    return sdf.format(date);
  }

  public static double fromAmountToNumber(String amount) throws NumberFormatException {
    amount = amount.replaceAll(",", ".");
    return Double.parseDouble(amount);
  }

  /**
   * Returns a localized "yes" or "no" string based on the specified boolean value.
   *
   * @param yes the boolean value.
   * @return the localized "yes" or "no" string.
   */
  public static String yesNo(final boolean yes) {
    if (yes) {
      return Text.get("YES");
    } else {
      return Text.get("NO");
    }
  }

  /**
   * Returns the title for the filter based on the specified filter object.
   *
   * @param filter the filter object.
   * @return the title for the filter.
   */
  public static String getTitleFilter(final Filter filter) {
    Date time = filter.getTo();
    return switch (filter.getStep()) {
      case Filter.STEP_DAY -> date(time);
      case Filter.STEP_MONTH -> dateMonth(time);
      case Filter.STEP_YEAR -> dateYear(time);
      default -> null;
    };
  }

  private static class MainDateFormat extends DateFormatSymbols {
    @Override
    public String[] getMonths() {
      return Text.getMonths();
    }
  }
}
