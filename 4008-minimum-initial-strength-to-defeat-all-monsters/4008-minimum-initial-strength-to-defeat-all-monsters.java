class Solution {
    private boolean canDefeat(long initial,int[]monsters,long[]bonus){
        long strength=initial;
        for(int i=0;i<monsters.length;i++){
            if(strength+bonus[i]<monsters[i])return false;
            strength-=monsters[i];
            strength=Math.max(0,strength);

        }
        return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {
        long[]diff=new long[monsters.length+1];
        for(int[]boost:boosts){
            int l=boost[0];
            int r=boost[1];
            int v=boost[2];
            diff[l]+=v;
            diff[r+1]-=v;
        }
        long[]bonus=new long[monsters.length];
        long currentBonus=0;
        for(int i=0;i<monsters.length;i++){
            currentBonus+=diff[i];
            bonus[i]=currentBonus;
        }
        long low=0;
        long high=0;
        for(int monster:monsters){
            high+=monster;
        }
        while(low<high){
            long mid=low+(high-low)/2;
            if(canDefeat(mid,monsters,bonus))high=mid;
            else{
                low=mid+1;
            }
        }
        return low;

    }
}