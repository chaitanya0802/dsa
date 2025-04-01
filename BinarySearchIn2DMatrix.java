//for sorted array
//TC is O(n+m)

public class BinarySearchIn2DMatrix {

    public static void solution(int[][] matrix, int key) {
        // cols
        int m = matrix[0].length;
        // rows
        int n = matrix.length;

        // i is row
        // j is col
        // Start from top-right corner
        int i = 0, j = m - 1;

        while (i >= 0 && j >= 0 && i < n && j < m) {
            if (matrix[i][j] == key) {
                System.out.println("Key " + key + " found at: " + i + "," + j);
                return;
            } else if (key < matrix[i][j]) {
                // move left
                j--;
            } else {
                // move right
                i++;
            }
        }

        System.out.println("Key not found");
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 10, 20, 30, 40 },
                { 15, 25, 35, 45 },
                { 27, 29, 37, 48 },
                { 32, 33, 39, 50 }
        };

        solution(matrix, 50);
    }

}
