class Solution {
    public boolean isPalindromic(String s) {
        String binary="";
        for(char ch:s.toCharArray()){
            int ascii=ch;
            String temp=Integer.toBinaryString(ascii);
            while(temp.length()<8){
                temp='0'+temp;
            }
            binary+=temp;
            
        }
        for(int i=0;i<binary.length()/2;i++){
            if(binary.charAt(i)!=binary.charAt(binary.length()-1-i))return false;
        }
        return true;
        
    }
}