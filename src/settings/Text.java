package settings;

import java.util.Calendar;
import java.util.HashMap;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * The Text class provides localized text resources for the application.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class Text {

  private static final HashMap<String, String> data = new HashMap<>();
  private static final String[] months = {
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

  /**
   * Retrieves the localized text for the specified key.
   *
   * @param key the key for the desired text
   * @return the localized text associated with the key, or an empty string if the key is not found
   */
  public static String get(final String key) {
    if (data.containsKey(key)) {
      return data.get(key);
    }
    System.out.println("Такого ключа в Text не існує!");
    return "";
  }

  /**
   * Retrieves the localized names of the months.
   *
   * @return an array of localized month names
   */
  public static String[] getMonths() {
    String[] months = new String[Text.months.length];
    for (int i = 0; i < Text.months.length; i++) {
      months[i] = get(Text.months[i]);
    }
    return months;
  }

  /**
   * Initializes the text resources with localized strings.
   */
  public static void init() {
    data.put("PROGRAM_NAME", "Домашня бухгалтерія");
    data.put("MENU_FILE", "Файл");
    data.put("MENU_EDIT", "Редагувати");
    data.put("MENU_VIEW", "Перегляд");
    data.put("MENU_SETTINGS", "Налаштування");
    data.put("MENU_HELP", "Довідка");

    data.put("JANUARY", "Січень");
    data.put("FEBRUARY", "Лютий");
    data.put("MARCH", "Березень");
    data.put("APRIL", "Квітень");
    data.put("MAY", "Травень");
    data.put("JUNE", "Червень");
    data.put("JULY", "Липень");
    data.put("AUGUST", "Серпень");
    data.put("SEPTEMBER", "Вересень");
    data.put("OCTOBER", "Жовтень");
    data.put("NOVEMBER", "Листопад");
    data.put("DECEMBER", "Грудень");

    data.put("ERROR", "Помилка");
    data.put("ERROR_TITLE_EMPTY", "Ви не ввели назву!");
    data.put("ERROR_IS_EXISTS", "Такий запис вже існує!");
    data.put("ERROR_DATE_FORMAT", "Некоректний формат дати!");
    data.put("ERROR_CODE_EMPTY", "Ви не вказали код!");
    data.put("ERROR_CURRENCY_EMPTY", "Ви не обрали валюту!");
    data.put("ERROR_ARTICLE_EMPTY", "Ви не обрали статтю!");
    data.put("ERROR_ACCOUNT_EMPTY", "Ви не обрали рахунок!");
    data.put("ERROR_RATE_INCORRECT", "Некоректне значення курсу!");
    data.put("ERROR_AMOUNT_FORMAT", "Некоректний формат суми!");
    data.put("ERROR_NO_BASE_CURRENCY", "Необхідна базова валюта!");

    data.put("YES", "Так");
    data.put("NO", "Ні");

    data.put("MENU_FILE_NEW", "Новий");
    data.put("MENU_FILE_OPEN", "Відкрити");
    data.put("MENU_FILE_SAVE", "Зберегти");
    data.put("MENU_FILE_UPDATE_CURRENCIES", "Оновити курси валют");
    data.put("MENU_FILE_EXIT", "Вихід");

    data.put("MENU_EDIT_ADD", "Додати");
    data.put("MENU_EDIT_EDIT", "Змінити");
    data.put("MENU_EDIT_DELETE", "Видалити");

    data.put("MENU_VIEW_OVERVIEW", "Огляд");
    data.put("MENU_VIEW_ACCOUNTS", "Рахунки");
    data.put("MENU_VIEW_ARTICLES", "Статті");
    data.put("MENU_VIEW_TRANSACTIONS", "Транзакції");
    data.put("MENU_VIEW_TRANSFERS", "Перекази");
    data.put("MENU_VIEW_CURRENCIES", "Валюти");
    data.put("MENU_VIEW_STATISTICS", "Статистика");

    data.put("MENU_HELP_ABOUT", "Про програму");

    data.put("TOOLBAR_OVERVIEW", "Огляд");
    data.put("TOOLBAR_ACCOUNTS", "Рахунки");
    data.put("TOOLBAR_ARTICLES", "Статті");
    data.put("TOOLBAR_TRANSACTIONS", "Транзакції");
    data.put("TOOLBAR_TRANSFERS", "Перекази");
    data.put("TOOLBAR_CURRENCIES", "Валюти");
    data.put("TOOLBAR_STATISTICS", "Статистика");

    data.put("ADD", "Додати");
    data.put("EDIT", "Змінити");
    data.put("DELETE", "Видалити");
    data.put("CANCEL", "Відміна");

    data.put("TODAY", "Сьогодні");

    data.put("FC_HOME", "Домашня директорія");
    data.put("FC_OPEN", "Відкрити");
    data.put("FC_SAVE", "Зберегти");
    data.put("FC_CANCEL", "Скасувати");
    data.put("FC_LOOK", "Папка:");
    data.put("FC_NAME_FILE", "Ім'я файлу:");
    data.put("FC_TYPE_FILE", "Тип файлу:");
    data.put("FC_UP", "Вгору");
    data.put("FC_NEW_DIRECTORY", "Нова папка");
    data.put("FC_LIST", "Список");
    data.put("FC_TABLE", "Таблиця");
    data.put("FC_NAME", "Ім'я");
    data.put("FC_SIZE", "Розмір");
    data.put("FC_TYPE", "Тип");
    data.put("FC_DATE", "Дата");
    data.put("FC_ATTR", "Атрибути");
    data.put("FC_ALL_FILTER", "Всі файли");

    data.put("LABEL_TITLE", "Назва:");
    data.put("LABEL_CURRENCY", "Валюта:");
    data.put("LABEL_START_AMOUNT", "Початковий баланс:");
    data.put("LABEL_DATE", "Дата:");
    data.put("LABEL_ACCOUNT", "Рахунок:");
    data.put("LABEL_ARTICLE", "Стаття:");
    data.put("LABEL_AMOUNT", "Сума:");
    data.put("LABEL_NOTICE", "Примітка:");
    data.put("LABEL_FROM_ACCOUNT", "Звідки:");
    data.put("LABEL_TO_ACCOUNT", "Куди:");
    data.put("LABEL_FROM_AMOUNT", "Списано:");
    data.put("LABEL_TO_AMOUNT", "Зачислено:");
    data.put("LABEL_CODE", "Код:");
    data.put("LABEL_RATE", "Курс:");
    data.put("LABEL_ON", "Увімкнено:");
    data.put("LABEL_BASE", "Базова:");

    data.put("BALANCE_CURRENCIES", "Баланс по валютах");
    data.put("BALANCE", "Загальний баланс");

    data.put("LAST_TRANSACTIONS", "Останні транзакції");
    data.put("ACCOUNTS", "Рахунки");
    data.put("ARTICLES", "Статті");
    data.put("TRANSACTIONS", "Транзакції");
    data.put("TRANSFERS", "Перекази");
    data.put("CURRENCIES", "Валюти");
    data.put("STATISTICS", "Статистика");

    data.put("TITLE", "Назва");
    data.put("DATE", "Дата");
    data.put("ACCOUNT", "Рахунок");
    data.put("ARTICLE", "Стаття");
    data.put("AMOUNT", "Сума");
    data.put("NOTICE", "Примітка");
    data.put("FROM_ACCOUNT", "Звідки");
    data.put("TO_ACCOUNT", "Куди");
    data.put("FROM_AMOUNT", "Списано");
    data.put("TO_AMOUNT", "Зачислено");
    data.put("CODE", "Код");
    data.put("RATE", "Курс");
    data.put("ON", "Увімкнено");
    data.put("BASE", "Базова");

    data.put("CHART_INCOME", "Доходи за статтями");
    data.put("CHART_EXP", "Витрати за статтями");
    data.put("CHART_NO_DATA", "Немає даних за обраний період!");

    data.put("CONFIRM_EXIT_TEXT", "Ви дійсно хочете вийти? Всі незбережені дані будуть втрачені!");
    data.put("CONFIRM_EXIT_TITLE", "Підтвердження виходу");
    data.put("CONFIRM_DELETE_TEXT", "Ви впевнені, що хочете видалити цей запис?");
    data.put("CONFIRM_DELETE_TITLE", "Підтвердження видалення");

    data.put("DIALOG_ABOUT_TITLE", "Про програму");
    data.put("ABOUT",
        "<body style='font-size: 140%; text-align: center; width: 350px; margin: 0 auto; "
        + "p { text-align: justify; } p::first-letter { text-indent: 0px; }'>"
        + "<p><img src='file:src/gui/images/main.png' /></p>"
        + "<h1>Домашня бухгалтерія</h1>"
        + "<p> Мета додатка полягає у створенні зручного інтерфейсу для програмістів, "
        + "включаючи роботу з даними, збереження та завантаження даних, "
        + "створення базового інтерфейсу користувача, діалогових вікон, "
        + "виведення даних, статистики та обробки подій. </p>"
        + "<p> Україна, " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");
  }
}
