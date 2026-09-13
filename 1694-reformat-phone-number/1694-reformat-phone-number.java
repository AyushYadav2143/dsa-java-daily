class Solution {
    public String reformatNumber(String number) {
        String temp="";
        for(char ch:number.toCharArray()){
            if(ch==' ' || ch=='_' || ch=='-')continue;
            temp+=ch;
        }
        String res="";
        int i=0;
        int n=temp.length();
        while(n-i>4){
            if(res.length()>0){
                res+="-";

            }
            res+=temp.substring(i,i+3);
            i+=3;
        }
        int remaining=n-i;
        if(remaining==2 || remaining==3){
            if(res.length()>0){
                res+="-";
            }
            res+=temp.substring(i);
        }
        else if(remaining==4){
            if(res.length()>0){
                res+="-";
            }
            res+=temp.substring(i,i+2);
            res+="-";
            res+=temp.substring(i+2);
        }
        return res;
        
    }
}