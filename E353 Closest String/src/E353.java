/******************************************************************************
 *  Class: E353
 *  Author: nucleusfox
 *
 *  The Closest String
 *  Accepts lines of strings of the same length. Prints the "center" most
 *  closest to others string from the input.
 *
 *
 *  Reddit DailyProgrammer - #353 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/826coe/20180305_challenge_353_easy_closest_string/
 *
 *  Example:
 *  $ java E353
 *  CTCCATCACAC
 *  AATATCTACAT
 *  ACATTCTCCAT
 *  CCTCCCCACTC
 *
 *  Result:
 *  AATATCTACAT
 ******************************************************************************/
import java.util.*;

public class E353 {
    public static int HammingDistance(String line1, String line2) {
        int distance = 0;

        for (int i = 0; i < line1.length(); i++) {
            if (line1.charAt(i) != line2.charAt(i)) distance++;
        }
        return distance;
    }

    public static String findCenter(List<String> lines) {
        Map<String, Integer> distances = new LinkedHashMap<>();

        for (String line1 : lines) {
            for(String line2 : lines) {
                int summ = 0;
                if (distances.containsKey(line1)) summ = distances.get(line1);
                summ += HammingDistance(line1, line2);
                distances.put(line1, summ);
            }
        }

        int min = distances.get(lines.get(0));
        String center = lines.get(0);
        for (Map.Entry<String, Integer> d : distances.entrySet())
            if (d.getValue() < min) {
                min = d.getValue();
                center = d.getKey();
            }

        return center;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> lines = new LinkedList<>();

        while (!line.isEmpty()) {
            lines.add(line);
            line = sc.nextLine();
        }

        System.out.print(findCenter(lines));
    }
}