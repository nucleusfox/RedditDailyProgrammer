/******************************************************************************
 *  Class: EspeakTheTime
 *  Author: nucleusfox
 *
 *  Espeak The Time
 *  Accepts time in 24-hour format. Prints the time converted to 12-hour format
 *  and synthesize time reading through espeak program.
 *
 *  Reddit DailyProgrammer - Weekly #28 - Mini Challenges
 *  https://www.reddit.com/r/dailyprogrammer/comments/81aexf/weekly_28_mini_challenges/
 *  [espeak the time]
 *
 *  Example:
 *  $ java EspeakTheTime
 *  21:34
 *
 *  Result:
 *  "It's 9:45 PM"
 *
 ******************************************************************************/
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

public class EspeakTheTime {
    public static void speak(String time) {
        String timePhrase = "\"It's "+ time + "\"";
        System.out.println(timePhrase);

        try {
            ProcessBuilder pb = new ProcessBuilder("espeak", timePhrase);
            Process p = pb.start();

            int returnVal = p.waitFor();
            //System.out.println ("exit: " + returnVal);
            p.destroy();
        } catch (Exception e) {}
    }

    public static String convertTo12(Date time) {
        long datetime = time.getTime();
        long hours = datetime / (60 * 60 * 1000) % 24;
        long minutes = datetime / (60 * 1000) % 60;
//        System.out.println("Hours: " + hours);
//        System.out.println("Minutes: " + minutes);
        String newTimeString;
        if (hours > 12)
            newTimeString = String.valueOf(hours - 12) + ':' + minutes + " PM";
        else
            newTimeString = hours + ":" + minutes + " AM";

        return newTimeString;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String timeString = sc.nextLine();

        DateFormat dateFormat = new SimpleDateFormat("k:mm");

        try {
            dateFormat.setTimeZone(TimeZone.getTimeZone(ZoneId.of("UTC")));
            Date time = dateFormat.parse(timeString);
            speak(convertTo12(time));

        } catch (ParseException e) {
            e.printStackTrace();
        }



    }
}
