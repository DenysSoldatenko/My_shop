package settings;

import java.util.HashMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Text {

  private static final HashMap<String, String> DATA = new HashMap<>();
  private static final String[] MONTHS = {
    "JANUARY",
    "FEBRUARY",
    "MARCH",
    "APRIL",
    "MAY",
    "JUNE",
    "JULY",
    "AUGUST",
    "SEPTEMBER",
    "OCTOBER",
    "NOVEMBER",
    "DECEMBER"
  };

  public static String get(final String key) {
    if (DATA.containsKey(key)) {
      return DATA.get(key);
    }
    System.out.println("Такого ключа в Text не існує!");
    return "";
  }

  public static String[] getMonths() {
    String[] months = new String[MONTHS.length];
    for (int i = 0; i < MONTHS.length; i++) {
      months[i] = get(MONTHS[i]);
    }
    return months;
  }

  public static void init() {
    DATA.put("PROGRAM_NAME", "Домашня бухгалтерія");
    DATA.put("MENU_FILE", "Файл");
    DATA.put("MENU_EDIT", "Редагувати");
    DATA.put("MENU_VIEW", "Перегляд");
    DATA.put("MENU_SETTINGS", "Налаштування");
    DATA.put("MENU_HELP", "Довідка");

    DATA.put("JANUARY", "Січень");
    DATA.put("FEBRUARY", "Лютий");
    DATA.put("MARCH", "Березень");
    DATA.put("APRIL", "Квітень");
    DATA.put("MAY", "Травень");
    DATA.put("JUNE", "Червень");
    DATA.put("JULY", "Липень");
    DATA.put("AUGUST", "Серпень");
    DATA.put("SEPTEMBER", "Вересень");
    DATA.put("OCTOBER", "Жовтень");
    DATA.put("NOVEMBER", "Листопад");
    DATA.put("DECEMBER", "Грудень");

    DATA.put("ERROR", "Помилка");
    DATA.put("ERROR_TITLE_EMPTY", "Ви не ввели назву!");
    DATA.put("ERROR_IS_EXISTS", "Такий запис вже існує!");
    DATA.put("ERROR_DATE_FORMAT", "Некоректний формат дати!");
    DATA.put("ERROR_CODE_EMPTY", "Ви не вказали код!");
    DATA.put("ERROR_CURRENCY_EMPTY", "Ви не обрали валюту!");
    DATA.put("ERROR_ARTICLE_EMPTY", "Ви не обрали статтю!");
    DATA.put("ERROR_ACCOUNT_EMPTY", "Ви не обрали рахунок!");
    DATA.put("ERROR_RATE_INCORRECT", "Некоректне значення курсу!");
    DATA.put("ERROR_AMOUNT_FORMAT", "Некоректний формат суми!");
    DATA.put("ERROR_NO_BASE_CURRENCY", "Необхідна базова валюта!");

    DATA.put("YES", "Так");
    DATA.put("NO", "Ні");

    DATA.put("MENU_FILE_NEW", "Новий");
    DATA.put("MENU_FILE_OPEN", "Відкрити");
    DATA.put("MENU_FILE_SAVE", "Зберегти");
    DATA.put("MENU_FILE_UPDATE_CURRENCIES", "Оновити курси валют");
    DATA.put("MENU_FILE_EXIT", "Вихід");

    DATA.put("MENU_EDIT_ADD", "Додати");
    DATA.put("MENU_EDIT_EDIT", "Змінити");
    DATA.put("MENU_EDIT_DELETE", "Видалити");

    DATA.put("MENU_VIEW_OVERVIEW", "Огляд");
    DATA.put("MENU_VIEW_ACCOUNTS", "Рахунки");
    DATA.put("MENU_VIEW_ARTICLES", "Статті");
    DATA.put("MENU_VIEW_TRANSACTIONS", "Транзакції");
    DATA.put("MENU_VIEW_TRANSFERS", "Перекази");
    DATA.put("MENU_VIEW_CURRENCIES", "Валюти");
    DATA.put("MENU_VIEW_STATISTICS", "Статистика");

    DATA.put("MENU_HELP_ABOUT", "Про програму");

    DATA.put("TOOLBAR_OVERVIEW", "Огляд");
    DATA.put("TOOLBAR_ACCOUNTS", "Рахунки");
    DATA.put("TOOLBAR_ARTICLES", "Статті");
    DATA.put("TOOLBAR_TRANSACTIONS", "Транзакції");
    DATA.put("TOOLBAR_TRANSFERS", "Перекази");
    DATA.put("TOOLBAR_CURRENCIES", "Валюти");
    DATA.put("TOOLBAR_STATISTICS", "Статистика");

    DATA.put("ADD", "Додати");
    DATA.put("EDIT", "Змінити");
    DATA.put("DELETE", "Видалити");
    DATA.put("CANCEL", "Відміна");

    DATA.put("TODAY", "Сьогодні");
  }
}
