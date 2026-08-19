class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int maxGreen=0;
        for(int green:lights){
            maxGreen=Math.max(green,maxGreen);
        }
        int ans=0;
        for(int time:arrivalTime){
            int position=time%period;
            int wait;
            if(position<maxGreen){
                wait=0;
            }
            else{
                wait=period-position;
            }
            ans=Math.max(ans,wait);
        }
        return ans;
        
    }
}