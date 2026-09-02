class Solution {
    public String replaceDigits(String s) {
        String res="";
        char[]arr=s.toCharArray();
        for(int i=0;i<arr.length;i++){
            if(i%2!=0){
                char ch=arr[i-1];
                int shiftNumber=arr[i]-'0';
                char shifted=(char)(ch+shiftNumber);
                res+=shifted;
            }
            else res+=arr[i];
        }
        return res;
        
    }
}