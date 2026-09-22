class Solution {
    public int minCharacters(String a, String b) {
        int[]freqA=new int[26];
        int[]freqB=new int[26];
        for(char ch:a.toCharArray()){
            freqA[ch-'a']++;
        }
        for(char ch:b.toCharArray()){
            freqB[ch-'a']++;
        }
        int ans=Integer.MAX_VALUE;
        int countA=0;
        int countB=0;
        for(int i=0;i<25;i++){
            countA+=freqA[i];
            countB+=freqB[i];
            int changes1=(a.length()-countA)+countB;
            int changes2=(b.length()-countB)+countA;
            ans=Math.min(ans,changes1);
            ans=Math.min(ans,changes2);
        }
        for(int i=0;i<26;i++){
            int changes3=a.length()+b.length()-freqA[i]-freqB[i];
            ans=Math.min(ans,changes3);
        }
        return ans;

        
    }
}