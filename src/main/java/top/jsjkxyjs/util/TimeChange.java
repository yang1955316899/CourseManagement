package top.jsjkxyjs.util;

import com.google.gson.Gson;
import top.jsjkxyjs.entity.Time;

public class TimeChange {
	public String toString(Time time) {
//		String timeString = "";
//		timeString = "" + time.getYear() + "-" + time.getSemester() + "-" + time.getCode() + "-";
//		for (int index = 0; (time.getClassCode(index) != 0) && index < 10; index++)
//			timeString += index + ".";
//		return timeString;
		//Json写法
		Gson gson = new Gson();
		return gson.toJson(time);
	}

	public Time toTime(String timeString) {
//		Time time = new Time();
//		String[] tem = timeString.split("-");
		Gson gson = new Gson();
		return gson.fromJson(timeString, Time.class);
	}
}
