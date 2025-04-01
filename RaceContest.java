import java.util.Scanner;

public class RaceContest {
    public static int countContestants(int N, int[] S, int K, int M) {
        int count = 0;

        for (int speed : S) {
            int distanceCovered = 0;
            int currentSpeed = speed;

            for (int minute = 0; minute < M; minute++) {
                distanceCovered += currentSpeed;
                if (currentSpeed > 0) {
                    currentSpeed--; // Speed decreases by 1 each minute
                }
            }

            if (distanceCovered >= K) {
                count++;
            }
        }

        return count > 0 ? count : -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs
        int N = scanner.nextInt();
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            S[i] = scanner.nextInt();
        }

        int K = scanner.nextInt();
        int M = scanner.nextInt();

        // Calling the function and printing the result
        System.out.println(countContestants(N, S, K, M));

        scanner.close();
    }
}
