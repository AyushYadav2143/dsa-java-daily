class Solution {
    public int buyChoco(int[] prices, int money) {
        int chocolates=0;
        Arrays.sort(prices);
        if(prices[0]+prices[1]<=money){
            money-=prices[0];
            money-=prices[1];
        }
        return money;
        
    }
}