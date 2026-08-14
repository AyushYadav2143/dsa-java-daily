class Solution {
    public int findLUSlength(String a, String b) {
        if(a.equals(b))return -1;
        int len=0;
        len=Math.max(a.length(),b.length());
        return len;
        
        
    }
}