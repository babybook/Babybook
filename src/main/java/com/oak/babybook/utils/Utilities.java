package com.oak.babybook.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utilities {

	private static DateFormat formatter = DateFormat.getDateInstance();
	private static DateFormat dateParser = new SimpleDateFormat("yyyyMMdd");
	private static Calendar calendar = GregorianCalendar.getInstance();

	public static String getISODate(Date date){
		calendar.setTime(date);
		String monthStr;
		int month = calendar.get(Calendar.MONTH)+1;

		if (month < 10){
			monthStr = "0" + month;
		}else{
			monthStr = "" + month;
		}

		return calendar.get(Calendar.YEAR) + "" + monthStr + "" + calendar.get(Calendar.DATE);
	}

	public static Date parseDate(String isoDate) throws ParseException{
		return dateParser.parse(isoDate);
	}

	public static void main(String args[]) {

		System.out.println(Utilities.getISODate(new Date()));
		try {
			System.out.println(Utilities.parseDate("20090617").toString());

		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
