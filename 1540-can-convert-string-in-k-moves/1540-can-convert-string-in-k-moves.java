class Solution {
    public boolean canConvertString(String s, String t, int k) {
        if(s.length()!=t.length())return false;
        int[]freq=new int[26];
        for(int i=0;i<s.length();i++){
            int diff=(t.charAt(i)-s.charAt(i)+26)%26;
            if(diff==0)continue;
            int reqMoves=diff+26 *freq[diff];
            if(reqMoves>k)return false;
            freq[diff]++;
        }
        return true;
        
    }
}