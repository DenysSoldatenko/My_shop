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
    if (Settings.getLanguage().equals("uk")) {
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

      data.put("MENU_SETTINGS_LANGUAGE", "Мова");
      data.put("MENU_SETTINGS_LANGUAGE_UKRAINIAN", "Українська");
      data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "Англійська");

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

      data.put("CONFIRM_EXIT_TEXT", "Ви дійсно хочете вийти? "
          + "Всі незбережені дані будуть втрачені!");
      data.put("CONFIRM_EXIT_TITLE", "Підтвердження виходу");
      data.put("CONFIRM_DELETE_TEXT", "Ви впевнені, що хочете видалити цей запис?");
      data.put("CONFIRM_DELETE_TITLE", "Підтвердження видалення");

      data.put("DIALOG_ABOUT_TITLE", "Про програму");
      data.put("ABOUT",
          "<body style='font-size: 140%; text-align: center; width: 350px; margin: 0 auto; "
          + "p { text-align: justify; } p::first-letter { text-indent: 0px; }'>"
          + "<p><img src='file:src/settings/images/main.png' /></p>"
          + "<h1>Домашня бухгалтерія</h1>"
          + "<p> "
          + "Мета додатка полягає у створенні зручного інтерфейсу для користувача, "
          + "який містить в собі обробку даних, збереження та завантаження даних, "
          + "створення діалогових вікон, відображення інформації про валюти, "
          + "наявні транзакції та перекази, а також можливість створення "
          + "кругової діаграми на основі наявної інформації."
          + "</p>"
          + "<p> Україна, " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");
    } else {
      data.put("PROGRAM_NAME", "Personal Finance");

      data.put("JANUARY", "January");
      data.put("FEBRUARY", "February");
      data.put("MARCH", "March");
      data.put("APRIL", "April");
      data.put("MAY", "May");
      data.put("JUNE", "June");
      data.put("JULY", "July");
      data.put("AUGUST", "August");
      data.put("SEPTEMBER", "September");
      data.put("OCTOBER", "October");
      data.put("NOVEMBER", "November");
      data.put("DECEMBER", "December");

      data.put("ERROR", "Error");
      data.put("ERROR_TITLE_EMPTY", "You have not entered a name!");
      data.put("ERROR_IS_EXISTS", "This entry already exists!");
      data.put("ERROR_DATE_FORMAT", "Invalid date format!");
      data.put("ERROR_CODE_EMPTY", "Вы не указали код!");
      data.put("ERROR_CURRENCY_EMPTY", "You did not specify the currency!");
      data.put("ERROR_ARTICLE_EMPTY", "You did not specify an article!");
      data.put("ERROR_ACCOUNT_EMPTY", "You did not specify an account!");
      data.put("ERROR_RATE_INCORRECT", "Invalid rate value!");
      data.put("ERROR_AMOUNT_FORMAT", "Invalid amount format!");
      data.put("ERROR_NO_BASE_CURRENCY", "Base currency required! "
          + "First set this parameter in another currency, "
          + "then it will be removed in this automatically.");
      data.put("ERROR_UPDATE_CURRENCIES", "Error updating currencies!");

      data.put("CONFIRM_EXIT_TEXT", "Do you really want to exit? All unsaved data will be lost!");
      data.put("CONFIRM_EXIT_TITLE", "Exit confirmation");
      data.put("CONFIRM_DELETE_TEXT", "Are you sure you want to delete this entry?");
      data.put("CONFIRM_DELETE_TITLE", "Confirm");

      data.put("YES", "Yes");
      data.put("NO", "No");

      data.put("MENU_FILE", "File");
      data.put("MENU_EDIT", "Edit");
      data.put("MENU_VIEW", "View");
      data.put("MENU_SETTINGS", "Settings");
      data.put("MENU_HELP", "Help");

      data.put("MENU_FILE_NEW", "New");
      data.put("MENU_FILE_OPEN", "Open");
      data.put("MENU_FILE_SAVE", "Save");
      data.put("MENU_FILE_UPDATE_CURRENCIES", "Update currencies");
      data.put("MENU_FILE_EXIT", "Exit");

      data.put("MENU_EDIT_ADD", "Add");
      data.put("MENU_EDIT_EDIT", "Edit");
      data.put("MENU_EDIT_DELETE", "Delete");

      data.put("MENU_VIEW_OVERVIEW", "Overview");
      data.put("MENU_VIEW_ACCOUNTS", "Accounts");
      data.put("MENU_VIEW_ARTICLES", "Articles");
      data.put("MENU_VIEW_TRANSACTIONS", "Transactions");
      data.put("MENU_VIEW_TRANSFERS", "Transfers");
      data.put("MENU_VIEW_CURRENCIES", "Currencies");
      data.put("MENU_VIEW_STATISTICS", "Statistics");

      data.put("MENU_SETTINGS_LANGUAGE", "Language");
      data.put("MENU_SETTINGS_LANGUAGE_UKRAINIAN", "Ukrainian");
      data.put("MENU_SETTINGS_LANGUAGE_ENGLISH", "English");

      data.put("MENU_HELP_ABOUT", "About");

      data.put("TOOLBAR_OVERVIEW", "Overview");
      data.put("TOOLBAR_ACCOUNTS", "Accounts");
      data.put("TOOLBAR_ARTICLES", "Articles");
      data.put("TOOLBAR_TRANSACTIONS", "Transactions");
      data.put("TOOLBAR_TRANSFERS", "Transfers");
      data.put("TOOLBAR_CURRENCIES", "Currencies");
      data.put("TOOLBAR_STATISTICS", "Statistics");

      data.put("ADD", "Add");
      data.put("EDIT", "Edit");
      data.put("DELETE", "Delete");
      data.put("CANCEL", "Cancel");

      data.put("TODAY", "Today");

      data.put("LABEL_TITLE", "Title:");
      data.put("LABEL_CURRENCY", "Currency:");
      data.put("LABEL_START_AMOUNT", "Start amount:");
      data.put("LABEL_DATE", "Date:");
      data.put("LABEL_ACCOUNT", "Account:");
      data.put("LABEL_ARTICLE", "Article:");
      data.put("LABEL_AMOUNT", "Amount:");
      data.put("LABEL_NOTICE", "Notice:");
      data.put("LABEL_FROM_ACCOUNT", "From:");
      data.put("LABEL_TO_ACCOUNT", "To:");
      data.put("LABEL_FROM_AMOUNT", "Withdrawn:");
      data.put("LABEL_TO_AMOUNT", "Credited:");
      data.put("LABEL_CODE", "Code:");
      data.put("LABEL_RATE", "Rate:");
      data.put("LABEL_ON", "Enable:");
      data.put("LABEL_BASE", "Basic:");

      data.put("BALANCE_CURRENCIES", "Balance by currencies");
      data.put("BALANCE", "Total balance");

      data.put("FC_HOME", "Home");
      data.put("FC_OPEN", "Open");
      data.put("FC_SAVE", "Save");
      data.put("FC_CANCEL", "Cancel");
      data.put("FC_LOOK", "Folder:");
      data.put("FC_NAME_FILE", "File name:");
      data.put("FC_TYPE_FILE", "File type:");
      data.put("FC_UP", "Up");
      data.put("FC_NEW_DIRECTORY", "New folder");
      data.put("FC_LIST", "List");
      data.put("FC_TABLE", "Table");
      data.put("FC_NAME", "Name");
      data.put("FC_SIZE", "Size");
      data.put("FC_TYPE", "Type");
      data.put("FC_DATE", "Date");
      data.put("FC_ATTR", "Attributes");
      data.put("FC_ALL_FILTER", "All files");

      data.put("LAST_TRANSACTIONS", "Last transactions");
      data.put("ACCOUNTS", "Accounts");
      data.put("ARTICLES", "Articles");
      data.put("CURRENCIES", "Currencies");
      data.put("TRANSACTIONS", "Transactions");
      data.put("TRANSFERS", "Transfers");
      data.put("STATISTICS", "Statistics");

      data.put("TITLE", "Title");
      data.put("DATE", "Date");
      data.put("ACCOUNT", "Account");
      data.put("ARTICLE", "Article");
      data.put("AMOUNT", "Amount");
      data.put("NOTICE", "Notice");
      data.put("FROM_ACCOUNT", "From");
      data.put("TO_ACCOUNT", "To");
      data.put("FROM_AMOUNT", "Withdrawn");
      data.put("TO_AMOUNT", "Credited");
      data.put("CODE", "Code");
      data.put("RATE", "Rate");
      data.put("ON", "Enable");
      data.put("BASE", "Basic");

      data.put("CHART_INCOME", "Incomes by articles");
      data.put("CHART_EXP", "Expenses by articles");
      data.put("CHART_NO_DATA", "No data for the selected period!");

      data.put("DIALOG_ABOUT_TITLE", "About the program");
      data.put("ABOUT",
          "<body style='font-size: 140%; text-align: center; width: 350px; margin: 0 auto;"
          + "p { text-align: justify; } p::first-letter { text-indent: 0px; }'>"
          + "<p><img src='file:src/settings/images/main.png' /></p>"
          + "<h1>Home Accounting</h1>"
          + "<p> "
          + "The purpose of the application is to create a convenient user interface, "
          + "which includes data processing, saving and loading data, "
          + "creating dialogs, displaying information about currencies, "
          + "existing transactions and transfers, as well as the ability to create a "
          + "pie chart based on the available information."
          + "</p>"
          + "<p> Ukraine, " + Calendar.getInstance().get(Calendar.YEAR) + " </p></body>");
    }
  }
}
