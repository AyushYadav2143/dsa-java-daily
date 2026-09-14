class Solution {
    static final long mod=1000000007;
    public int stringCount(int n) {
        long[][][]dp=new long[3][2][2];
        dp[0][0][0]=1;
        for(int i=0;i<n;i++){
            long[][][]next=new long[3][2][2];
            for(int e=0;e<=2;e++){
                for(int l=0;l<=1;l++){
                    for(int t=0;t<=1;t++){
                        long ways=dp[e][l][t];
                        if(ways==0)continue;
                        int newE=Math.min(2,e+1);
                        next[newE][l][t]=(next[newE][l][t]+ways)%mod;
                        next[e][1][t]=(next[e][1][t]+ways)%mod;
                        next[e][l][1]=(next[e][l][1]+ways)%mod;
                        next[e][l][t]=(next[e][l][t]+ways*23)%mod;
                    }
                }
            }
            dp=next;
        }
        return (int)dp[2][1][1];        
    }
}