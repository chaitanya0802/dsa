public class StocksBuySell{

    static int solution(int[] prices){
        int maxProfit = 0;

        int buyPrice = Integer.MAX_VALUE;

        for(int i = 0; i<prices.length; i++){
            if(buyPrice < prices[i]){
                maxProfit = Math.max(maxProfit, buyPrice - prices[i]);
            }else{
                buyPrice = prices[i];
            }
        }

        return maxProfit;
    }


    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};

        System.out.println(solution(prices));
    }
}
