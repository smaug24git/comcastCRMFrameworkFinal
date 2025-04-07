package com.comcast.crm.generic.webdriverutility;

/**
 * 
 * @author SANU
 * test class for action releted to java-based
 * contains methods like getting random number for unique data,
 * getting a specific system date, a date prior or next to a specfic date
 *
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	public int getRandomNumber() {
		Random r = new Random();
		int randomNum = r.nextInt();

		return randomNum;
	}

	public String getSystemDate() {
		Date dObj = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		String date = s.format(dObj);

		return date;
	}

	public String getReqiuredDate(int days) {

		Date dObj = new Date();
		SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
		s.format(dObj);

		Calendar cal = s.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String requiedDate = s.format(cal.getTime());

		return requiedDate;

	}

}
