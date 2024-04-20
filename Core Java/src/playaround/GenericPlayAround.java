package playaround;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GenericPlayAround {

	public static void main(String[] args) {
		String dateString = "2024-04-12-12.04.35.100032";
		String formatString = "yyyy-MM-dd-HH.mm.ss.SSSSSS";

		Timestamp timestamp = parseStringToTimestamp(dateString, formatString);
		System.out.println(timestamp);
	}

	public static Timestamp parseStringToTimestamp(String dateString, String formatString) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formatString);
		LocalDateTime localDateTime = LocalDateTime.parse(dateString, formatter);
		return Timestamp.valueOf(localDateTime);
	}

}
