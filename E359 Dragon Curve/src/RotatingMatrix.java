/******************************************************************************
 *  Class: RotatingMatrix
 *  Author: nucleusfox
 *
 *  Rotating Matrix
 *  Rotates 2D vector pi/2 left or right.
 ******************************************************************************/
import java.util.Arrays;

public class RotatingMatrix {
    private static int[][] L = new int[2][2];
    private static int[][] R = new int[2][2];

    static {
        L[0][0] = 0;    L[0][1] = -1;
        L[1][0] = 1;    L[1][1] = 0;
        R[0][0] = 0;    R[0][1] = 1;
        R[1][0] = -1;   R[1][1] = 0;
    }

    public static int[] rotateLeft(int[] vector) {
        int[] r = new int[2];
        r[0] = L[0][0] * vector[0] - L[0][1] * vector[1];
        r[1] = - L[1][0] * vector[0] + L[1][1] * vector[1];
        return r;
    }

    public static int[] rotateRight(int[] vector) {
        int[] r = new int[2];
        r[0] = R[0][0] * vector[0] - R[0][1] * vector[1];
        r[1] = - R[1][0] * vector[0] + R[1][1] * vector[1];
        return r;
    }

    private static void printVector(int[] vector) {
        System.out.println(Arrays.toString(vector));
    }
}
