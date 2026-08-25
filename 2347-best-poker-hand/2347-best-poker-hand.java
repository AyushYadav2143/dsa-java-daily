class Solution {
    public String bestHand(int[] ranks, char[] suits) {
        boolean flush=true;
        for(int i=1;i<5;i++){
            if(suits[i]!=suits[0]){
                flush=false;
                break;
            }
        }
        if(flush)return "Flush";
        int[]freq=new int[14];
        for(int rank:ranks){
            freq[rank]++;
        }
        for(int count:freq){
            if(count>=3)return "Three of a Kind";
        }
        for(int count:freq){
            if(count>=2)return "Pair";
        }
        return "High Card";

        
    }
}