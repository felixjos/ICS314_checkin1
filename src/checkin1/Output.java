package checkin1;
import java.io.*;
import java.util.*;

public class Output {
	
	String summary, location, DTSTART, DTEND, classification, timezone;
	int priority;
	
	public Output(String summary, String location, String DTSTART, String DTEND, String classification, int priority, String timezone) {
		this.summary = summary;
		this.location = location;
		this.DTSTART = DTSTART;
		this.DTEND = DTEND;
		this.classification = classification;
		this.priority = priority;
		this.timezone = timezone;
	}
	
	public void fo() throws IOException {
		
		/*
		BEGIN:VCALENDAR
       	VERSION:2.0
       	BEGIN:VEVENT
       	DTSTART;TZID=Zone:19960918T143000Z
       	DTEND;TZID=Zone:19960920T220000Z
       	SUMMARY:Networld+Interop Conference
		LOCATION: Place
		PRIORITY: 0
		CLASS: PUBLIC
       	END:VEVENT
       	END:VCALENDAR
		 */
		
		String begin = "BEGIN:VCALENDAR\n";
		String version = "VERSION:1.0\n";
		String ebegin = "BEGIN:VEVENT\n";
		String dtstart = "DTSTART;"+ timezone + ":" + DTSTART + "\n";
		String dtend = "DTEND;" + timezone + ":" + DTEND + "\n";
		String summary = "SUMMARY:" + this.summary + "\n";
		String location = "LOCATION:" + this.location + "\n";
		String priority = "PRIORITY:" + Integer.toString(this.priority) + "\n";
		String classification = "CLASS:" + this.classification + "\n";
		String eend = "END:VEVENT\n";
		String end = "END:VCALENDAR\n";
		
			PrintWriter event = new PrintWriter(new FileWriter("event1.ics"));
			event.write(begin+version+ebegin+dtstart+dtend+summary+location+priority+classification+eend+end);
			event.close();
		
	}
}
