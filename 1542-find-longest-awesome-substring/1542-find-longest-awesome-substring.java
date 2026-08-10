class Solution {
    public int longestAwesome(String s) {
        int[]first=new int[1<<10];
        Arrays.fill(first,-2);
        first[0]=-1;
        int mask=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            int digit=s.charAt(i)-'0';
            mask^=(1<<digit);
            if(first[mask]!=-2){
                ans=Math.max(ans,i-first[mask]);
            }
            for(int bit=0;bit<10;bit++){
                int newMask=mask^(1<<bit);
                if(first[newMask]!=-2){
                    ans=Math.max(ans,i-first[newMask]);
                }
            }
            if(first[mask]==-2)first[mask]=i;
        }
        return ans;
        
    }
}