class Solution {
    public int bitwiseComplement(int n) {
        String binary=Integer.toBinaryString(n);
        String res="";
        for(int i=0;i<binary.length();i++){
            if(binary.charAt(i)=='1')res+='0';
            else res+='1';
        }
        int ans=Integer.parseInt(res,2);
        return ans;

        
    }
}