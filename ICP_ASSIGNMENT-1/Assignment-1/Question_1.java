import java.util.*;

public class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Take the size of the input
        int n = sc.nextInt();
        int[][] points = new int[n][2];
        // Take each interval as input
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        // Output the result
        System.out.println(findMinArrowShots(points));
    }
    public static int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        long c = 1;
        long temp = points[0][1];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > temp) {
                c++;
                temp = points[i][1];
            } else {
                temp = Math.min(points[i][1], temp);
            }
        }
        return (int) c;
    }
}
