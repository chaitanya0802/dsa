public class kadanealgo{

    //to find max sum of subarray
    
    
    static int maxSubarraySum(int[] arr){
        int res = arr[0];

        for(int i=0; i<arr.length; i++){
            int currsum = 0;
            for(int j=i; j<arr.length; j++){
                currsum = currsum + arr[j];

                res = Math.max(res, currsum);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, -8, 7, -1, 2, 3};
        System.out.println(maxSubarraySum(arr));
    }
}