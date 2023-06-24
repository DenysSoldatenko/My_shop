package datastorages;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import settings.Settings;

/**
 * The SaveLoad class provides methods for loading and saving data using JSON serialization.
 */
public class SaveLoad {

  /**
   * Loads data from a JSON file and populates the provided SaveData object.
   *
   * @param saveData The SaveData object to populate with loaded data.
   */
  public static void load(SaveData saveData) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      Wrapper wrapper = objectMapper
           .readValue(Settings.getFileSave(), Wrapper.class);

      saveData.setAccounts(wrapper.getAccounts());
      saveData.setArticles(wrapper.getArticles());
      saveData.setTransactions(wrapper.getTransactions());
      saveData.setTransfers(wrapper.getTransfers());
      saveData.setCurrencies(wrapper.getCurrencies());
    } catch (Exception exception) {
      System.out.println("Файл не існує!");
      Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, exception);
    }
  }

  /**
   * Saves the data from the provided SaveData object to a JSON file.
   *
   * @param saveData The SaveData object containing the data to be saved.
   */
  public static void save(SaveData saveData) {
    try {
      ObjectMapper objectMapper = new ObjectMapper();
      objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
      objectMapper.setDateFormat(new StdDateFormat().withColonInTimeZone(true));

      Wrapper wrapper = new Wrapper();
      wrapper.setAccounts(saveData.getAccounts());
      wrapper.setArticles(saveData.getArticles());
      wrapper.setTransactions(saveData.getTransactions());
      wrapper.setTransfers(saveData.getTransfers());
      wrapper.setCurrencies(saveData.getCurrencies());

      objectMapper.writeValue(Settings.getFileSave(), wrapper);
    } catch (Exception exception) {
      Logger.getLogger(SaveLoad.class.getName()).log(Level.SEVERE, null, exception);
    }
  }
}
