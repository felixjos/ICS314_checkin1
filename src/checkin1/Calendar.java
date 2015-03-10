package checkin1;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Calendar {

	public static void main(String[] args) throws IOException {
		/*
			• Version (section 3.7.4 of RFC 5545) Text: exp 2.0
			• Classification (3.8.1.3) Text: public / private / confidential
			• Location (3.8.1.7) Text: info
			• Priority (3.8.1.9) Integer: 0 - 9  High = 0-4 Medium = 5 Low = 6-9
			• Summary (3.8.1.12) Text: info
			• DTSTART (3.8.2.4) DATE-TIME: 
			• DTEND (3.8.2.2) DATE-TIME: 
			• Time zone identifier Text: 
		*/
		
		/* Studying for finals,
		 * Hamilton Library,
		 * 6-10pm HST 8 May 2015,
		 * high priority,
		 * public 
		 */
		String Classification, Location, TimeZone, Summary;
		int Priority;
		String DTSTART_date, DTSTART_time, DTEND_date, DTEND_time;
		String DTSTART, DTEND;
		
		Scanner input = new Scanner(System.in);
		try {
			System.out.print("Please input Summary: ");
			Summary = input.nextLine();
			
			System.out.print("Please input Location: ");
			Location = input.nextLine();
			
			System.out.print("Please input Start Date (YYYYMMDD): ");
			DTSTART_date = input.nextLine();
			
			System.out.print("Please input Start Time (HHMM): ");
			DTSTART_time = input.nextLine();
			
			System.out.print("Please input End Date (YYYYMMDD): ");
			DTEND_date = input.nextLine();
			
			System.out.print("Please input End Time (HHMM): ");
			DTEND_time = input.nextLine();
			
			System.out.print("Please input Classification (Public/Private/Confidential): ");
			Classification = input.nextLine();
			
			System.out.print("Please input Priority (High 0 - 9 Low): ");
			Priority = input.nextInt();
			
			System.out.print("Please input Time Zone (Ex. HST): ");
			TimeZone = input.nextLine();
			
			DTSTART = "" + DTSTART_date + "T" + DTSTART_time + "00";
			DTEND = "" + DTEND_date + "T" + DTEND_time + "00";
			
			System.out.println("Thank you for entering your data.  Generating File now.");
			
			Output outputfile =  new Output(Summary, Location, DTSTART, DTEND, Classification, Priority, TimeZone);
			outputfile.fo();
		}
		catch(InputMismatchException ime){
			System.out.println("Wrong Input: Entered String instead of Integers.");
		}
		catch(NoSuchElementException nsee){
			System.out.println("Wrong Input: No Input.");
		}
		input.close();
	}
}
