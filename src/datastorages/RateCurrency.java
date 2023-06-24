package datastorages;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 * The RateCurrency class provides methods for retrieving currency exchange rates from an API.
 */
public class RateCurrency {

  /**
   * Retrieves the currency exchange rates from the API.
   *
   * @return a HashMap containing currency codes as keys and their corresponding rates as values.
   */
  public static HashMap<String, Double> getRates() {
    HashMap<String, Double> result = new HashMap<>();

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
    String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?date="
        + dateFormat.format(new Date()) + "&json";
    System.out.println(url);
    JSONArray jsonArray = getJsonArrayFromUrl(url);

    if (jsonArray != null) {
      for (int i = 0; i < jsonArray.length(); i++) {
        JSONObject object = jsonArray.getJSONObject(i);
        double rate = object.getDouble("rate");
        String cc = object.getString("cc");
        result.put(cc, rate);
      }
    }

    return result;
  }

  /**
   * Retrieves a JSON array from the specified URL.
   *
   * @param url the URL from which to retrieve the JSON array.
   * @return the JSON array retrieved from the URL, or null if an error occurred.
   */
  private static JSONArray getJsonArrayFromUrl(String url) {
    try {
      URL apiUrl = new URL(url);
      HttpURLConnection con = (HttpURLConnection) apiUrl.openConnection();
      con.setRequestMethod("GET");

      int responseCode = con.getResponseCode();
      if (responseCode == HttpURLConnection.HTTP_OK) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
          response.append(line);
        }
        reader.close();
        return new JSONArray(response.toString());
      } else {
        System.out.println("HTTP request failed with response code: " + responseCode);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }
}
