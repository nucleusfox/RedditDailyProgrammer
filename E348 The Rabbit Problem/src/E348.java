/******************************************************************************
 *  Class: E348
 *  Author: nucleusfox
 *
 *  The Rabbit Problem
 *
 *
 *  Reddit DailyProgrammer - #348 [EASY]
 *  https://www.reddit.com/r/dailyprogrammer/comments/7s888w/20180122_challenge_348_easy_the_rabbit_problem/
 *
 *  Example:
 *  $ java E348
 *  1 2 10
 *
 *  Result:
 *  month 0 (3)	f [0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	m [0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	 dead : 0
 *  month 1 (3)	f [0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	m [0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	 dead : 0
 *  month 2 (3)	f [0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	m [0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	 dead : 0
 *  month 3 (31)	f [18, 0, 0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	m [10, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]	 dead : 0
 *
 ******************************************************************************/
import java.util.*;

public class E348 {
    public static final int DEATH_AGE = 40;
    public static final int FERTILE_AGE = 4;
    public static final int NEWBORNS_FEMALE = 9;
    public static final int NEWBORNS_MALE = 5;
    public static final int INITIAL_FEMALE = 4;
    public static final int INITIAL_MALE = 2;
    public static final int INITIAL_AGE = 2;
    public static final int LIMIT = 1000000000;


    public static int count(int[] rabbits) {
        int sum = 0;
        for (int r : rabbits) sum+=r;
        return sum;
    }

    public static void print(int[] rabbits) {
        System.out.print(Arrays.toString(rabbits));
    }

   public static void printGeneration(int month, int total, int[] f, int[] m, int dead) {
        System.out.print("month " + month + " (" + ( total ) + ")");
        System.out.print("\tf ");
        print(f);
        System.out.print("\tm ");
        print(m);
        System.out.println("\t dead : " + dead);
    }


    public static int growUp(int[] r) {
        int dead = r[0];
        for (int j = r.length-1; j>0; j--)
            r[j] = r[j-1];
        r[0] = 0;
        return dead;
    }

    public static int breed(int[] f, int[] m) {
        int newborns = 0;
        for (int i = FERTILE_AGE+1; i < f.length; i++) {
            f[0] += NEWBORNS_FEMALE * f[i];
            m[0] += NEWBORNS_MALE * f[i];
            newborns += NEWBORNS_FEMALE * f[i] + NEWBORNS_MALE * f[i];
        }
        return newborns;
    }

    public static int simulate(int initial_male, int initial_female, int limit) {
        int [] f = new int[DEATH_AGE];
        int [] m = new int[DEATH_AGE];
        f[INITIAL_AGE] = initial_female;
        m[INITIAL_AGE] = initial_male;

        int total = count(f) + count(m);
        int month = 0;

        printGeneration(month, total, f, m, 0);

        while (total < limit) {
            int dead = growUp(f);
            dead += growUp(m);
            total += breed(f,m);

            printGeneration(++month, total, f, m, dead);
        }

        return month;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int male = sc.nextInt();
        int female = sc.nextInt();
        int limit = sc.nextInt();
        simulate(male,female,limit);
    }
}