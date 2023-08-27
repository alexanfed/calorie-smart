package my.project.users.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	public static Long parseId(String id) {
		
		return (id==null) ? 0:Long.parseLong(id);
	}

	public static Long parseCalPerDay(String calPerDay) {

		return (calPerDay==null) ? 0:Long.parseLong(calPerDay);
	}
	
	public static Date parseDate(String str) {

		Date date = null;
		
		try {
			date = new SimpleDateFormat("yyyy-MM-dd").parse(str.trim());
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
			
		return date;
	}
}
