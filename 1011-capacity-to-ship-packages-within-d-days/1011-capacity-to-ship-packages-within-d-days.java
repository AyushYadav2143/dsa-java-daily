class Solution {
    private boolean canShip(int[]weights,int days,int capacity){
        int currentWeight=0;
        int requeiredDays=1;
        for(int weight:weights){
            if(currentWeight+weight>capacity){
                requeiredDays++;
                currentWeight=0;
            }
            currentWeight+=weight;
        }
        return requeiredDays<=days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(low,weight);
            high+=weight;
            
        }
        while(low<high){
            int mid=low+(high-low)/2;
            if(canShip(weights,days,mid))high=mid;
            else low=mid+1;
        }
        return low;
        
    }
}