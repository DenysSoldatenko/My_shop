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

public class RateCurrency {

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
