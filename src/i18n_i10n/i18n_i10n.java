package i18n_i10n;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * i18n - інтернаціональна
 * <p>
 * i10n - локалізована для певного регіону
 */

public class i18n_i10n        // якщо не вказана чітко мова, то буде використовуватись дефолтна без _
{
    public static void main(String[] args){

        Locale.setDefault(Locale.US);       // зміна поточного регіону на вказаний

        Locale localeUS = Locale.getDefault();                      // поточний регіон
        Locale localeGR = new Locale("de","GR");
        Locale localeRU = new Locale("ru","RU");

//        Locale[] locale = Locale.getAvailableLocales();     // усі доступні варіанти мов
//        for(Locale locale1 : locale)
//            System.out.println(locale1);

        System.out.println("\n---------------\n");

        System.out.println(NumberFormat.getCurrencyInstance(localeUS).format(100));     // грошові одиниці
        System.out.println(NumberFormat.getCurrencyInstance(localeGR).format(100));     // в певному регіоні
        System.out.println(NumberFormat.getCurrencyInstance(localeRU).format(100));     //

        System.out.println("\n---------------\n");

        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, localeUS).format(new Date()));     // дата в певному
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, localeGR).format(new Date()));     // форматі для певного
        System.out.println(DateFormat.getDateInstance(DateFormat.FULL, localeRU).format(new Date()));     // регіону

        System.out.println("\n---------------\n");
                                                                                                         // resources по дефолту - мова регіону
        ResourceBundle resourceBundleUS = ResourceBundle.getBundle("resources");                         // для зберігання ресурсів
        ResourceBundle resourceBundleGR = ResourceBundle.getBundle("resources", localeGR);      // з певним набором даних
        ResourceBundle resourceBundleRU = ResourceBundle.getBundle("resources", localeRU);      //

        System.out.println(resourceBundleUS.getString("greeting") + " - " + localeUS.getDisplayName());
        System.out.println(resourceBundleGR.getString("greeting") + " - " + localeGR.getDisplayName());
        System.out.println(resourceBundleRU.getString("greeting") + " - " + localeRU.getDisplayName());

        System.out.println("\n---------------\n");

        System.out.println(localeUS.toLanguageTag() + " - " + localeUS.toString() + " - " +
                localeUS.getDisplayScript() + " - " + localeUS.getDisplayVariant() + " - " +
                localeUS.getScript() + " - " + localeUS.getVariant() + " - " +localeUS.getISO3Country() + " - " +
                localeUS.getISO3Language());

    }
}