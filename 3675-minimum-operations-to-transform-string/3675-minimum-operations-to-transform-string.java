class Solution {
    public int minOperations(String s) {
        int ans=0;
        for(char ch:s.toCharArray()){
            int operations=(26-(ch-'a'))%26;
            ans=Math.max(ans,operations);
        }
        return ans;
        
    }
}