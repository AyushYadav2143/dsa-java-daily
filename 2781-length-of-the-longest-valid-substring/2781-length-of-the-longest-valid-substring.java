class Solution {
    public int longestValidSubstring(String word, List<String> forbidden) {
        Set<String>set=new HashSet<>(forbidden);
        int left=0;
        int ans=0;
        for(int right=0;right<word.length();right++){
            for(int len=1;len<=10 &&right-len+1>=left;len++){
                int start=right-len+1;
                String sub=word.substring(start,right+1);
                if(set.contains(sub)){
                    left=start+1;
                    break;
                }
            }
            ans=Math.max(ans,right-left+1);
        }
        return ans;
        
    }
}