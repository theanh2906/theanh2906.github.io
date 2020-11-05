package hcmiu.thesis.utils;

import java.util.Calendar;
import java.util.Date;

public class TimeUtil {
	public static Integer getYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.YEAR);
	}
}
