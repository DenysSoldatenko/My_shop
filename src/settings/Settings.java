package settings;

import java.io.File;
import java.io.IOException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.Preferences;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.ini4j.Ini;
import org.ini4j.IniPreferences;
import org.ini4j.Wini;

/**
 * The Settings class manages the application settings and configurations.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Settings {

  public static final File FONT_ROBOTO_LIGHT = new File("src/gui/fonts/Roboto-Light.ttf");
  public static final File SAVE_DIR = new File("src/configurations/");
  public static final String SAVE_FILE_EXT = "vap";
  public static final String FORMAT_AMOUNT = "%.2f";
  public static final String FORMAT_RATE = "%.4f";
  public static final String FORMAT_DATE = "dd.MM.yyyy";
  public static final String FORMAT_DATE_MONTH = "MMMM yyyy";
  public static final String FORMAT_DATE_YEAR = "yyyy";
  public static final int COUNT_OVERVIEW_ROWS = 10;
  public static final String[] CURRENCIES_CODES = new String[]{
    "USD", "EUR", "BYN", "UAH", "TRY",
    "GBP", "JPY", "CAD", "AUD", "CHF",
    "CNY", "NZD", "SEK", "NOK", "SGD",
    "MXN", "HKD", "INR", "BRL", "KRW"
  };
  private static final File FILE_SETTINGS
      = new File("src/configurations/settings.ini");
  private static File FILE_SAVE
      = new File("src/configurations/default.json");

  /**
   * Initializes the settings by reading from the settings.ini file.
   * If the file does not exist, it creates a new one and saves the default settings.
   */
  public static void init() {
    try {
      Ini ini = new Ini(FILE_SETTINGS);
      Preferences preferences = new IniPreferences(ini);
      String file = preferences.node("Settings")
          .get("FILE_SAVE", null);
      if (file != null) {
        FILE_SAVE = new File(file);
      }
      setLocale();
    } catch (IOException ex) {
      save();
    }
  }

  public static File getFileSave() {
    return FILE_SAVE;
  }

  public static void setFileSave(final File fileSave) {
    FILE_SAVE = fileSave;
    save();
  }

  private static void setLocale() {
    Locale.setDefault(new Locale("uk"));
  }

  private static void save() {
    try {
      Wini ini = new Wini(FILE_SETTINGS);
      if (FILE_SAVE != null) {
        ini.put("Settings", "FILE_SAVE",
             FILE_SAVE.getAbsolutePath()
             .replace("\\", "\\\\"));
      }
      ini.store();
    } catch (IOException ex) {
      Logger.getLogger(Settings.class.getName())
          .log(Level.SEVERE, null, ex);
    }
  }
}
