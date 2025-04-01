//TC and SC :  O(n)

public class DiagonalSum {

    public static void main(String[] args) {
        int[][] matrix = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };

        int sum = 0;

        for (int i = 0; i < matrix.length; i++) {
            //for primary matrix
            sum += matrix[i][i];

            //for secondary matrix

            // if 3x3 matrix [2][2] gets counted double
            // matrix.length-1 = i + j
            // hence if i is not equal to j
            if (i != matrix.length - 1 - i)
                sum += matrix[i][matrix.length - 1 - i];
        }

        System.out.println("the sum of matrix is: " + sum);

    }

}
