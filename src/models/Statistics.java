package models;

import datastorages.SaveData;
import java.util.HashMap;
import java.util.List;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Statistics {

  private static final int ROUNDING_FACTOR = 100;

  public static double getBalanceCurrency(final Currency currency) {
    SaveData sd = SaveData.getInstance();
    double amount = 0;
    for (Account account : sd.getAccounts()) {
      if (currency.equals(account.getCurrency())) {
        amount += account.getAmount();
      }
    }
    return amount;
  }

  public static double getBalance(final Currency cur) {
    SaveData sd = SaveData.getInstance();
    double amount = 0;
    for (Account account : sd.getAccounts()) {
      amount += account.getAmount()
         * account.getCurrency().getRateByCurrency(cur);
    }
    return amount;
  }

  public static HashMap<String, Double> getDataForChartOnIncArticles() {
    return getDataForChartOnArticles(true);
  }

  public static HashMap<String, Double> getDataForChartOnExpArticles() {
    return getDataForChartOnArticles(false);
  }

  private static HashMap<String, Double> getDataForChartOnArticles(
      final boolean income
  ) {
    List<Transaction> transactions = SaveData.getInstance().getTransactions();
    HashMap<String, Double> data = new HashMap<>();
    for (Transaction t : transactions) {
      if ((income && t.getAmount() > 0) || (!income && t.getAmount() < 0)) {
        String key = t.getArticle().getTitle();
        double summa = 0;
        double amount = t.getAmount();
        if (!income) {
          amount *= -1;
        }
        if (data.containsKey(key)) {
          summa = data.get(key);
        }
        summa += amount * t.getAccount().getCurrency()
            .getRateByCurrency(SaveData.getInstance().getBaseCurrency());
        data.put(key, round(summa));
      }
    }
    return data;
  }

  private static double round(final double value) {
    return (double)
     Math.round(value * ROUNDING_FACTOR) / ROUNDING_FACTOR;
  }
}

