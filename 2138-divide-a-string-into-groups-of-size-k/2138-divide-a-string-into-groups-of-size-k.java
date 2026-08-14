class Solution {
    public String[] divideString(String s, int k, char fill) {
        ArrayList<String>res=new ArrayList<>();
        String str="";
        for(int i=0;i<s.length();i++){
            
            char ch=s.charAt(i);
            str+=ch;
             if(str.length()==k){
                res.add(str);
                str="";
            }
            
           
            
        }
        if(str.length()>0 ){
                while(str.length()<k){
                    str+=fill;
                }
                res.add(str);
        }
        return res.toArray(new String[0]);
    }
}