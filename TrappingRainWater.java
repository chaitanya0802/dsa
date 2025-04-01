//trapping rainwater problem 
//TC: O(n^2)
//SC: O(1)

public class TrappingRainWater {

    // calculate the total volume of trapped water
    static int solution(int[] height) {
        int n = height.length;

        int totalvolume = 0;

        for (int i = 1; i < n - 1; i++) {

            // calculate max left height
            int maxLeft = height[i];
            for (int k = i; k >= 0; k--) {
                if (height[k] > maxLeft) {
                    maxLeft = height[k];
                }
            }

            // calculate max left height
            int maxRight = height[i];
            for (int l = i; l < n; l++) {
                if (height[l] > maxRight) {
                    maxRight = height[l];
                }
            }

            // if there is no bigger block than height[i], no water is trapped
            if (maxLeft == height[i] || maxRight == height[i]) {
                continue;
            } else {
                int waterLevel = Math.min(maxLeft, maxRight);
                int blockvolume = waterLevel - height[i];

                totalvolume += blockvolume;
            }

        }

        return totalvolume;
    }

    public static void main(String[] args) {
        int[] height = {4,2,0,3,2,5};

        System.out.println(solution(height));
    }
}
