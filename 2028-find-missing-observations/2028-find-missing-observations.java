class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int knownSum=0;
        for(int i:rolls)knownSum+=i;
        int totalElements=rolls.length+n;
        int totalSum=mean*totalElements;
        int missingSum=totalSum-knownSum;
        if(missingSum<n || missingSum>6*n)return new int[0];
        int[]ans=new int[n];
        for(int i=0;i<n;i++){
            ans[i]=1;
        }
        int extra=missingSum-n;
        for(int i=0;i<n && extra>0;i++){
            int add=Math.min(extra,5);
            ans[i]+=add;
            extra-=add;
        }
        return ans;
        

        
    }
}