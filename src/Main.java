import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import settings.Format;
import settings.Text;

public class Main {
	public static void main(String[] args) {
		Text.init();
		Date date = new GregorianCalendar(2023, Calendar.FEBRUARY, 11).getTime();
		System.out.println(Format.date(date));
		System.out.println(Text.get("PROGRAM_NAME"));
		System.out.println(Arrays.toString(Text.getMonths()));
	}
}