class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        ArrayList<String> string1=new ArrayList<>();
        String ch="";
        for(int i=0;i<s1.length();i++){
            
            if(s1.charAt(i)!=' '){
                ch+=s1.charAt(i);
                
            }
            else{
                string1.add(ch);
                ch="";
            }
        }
        if(!ch.isEmpty())string1.add(ch);
        String ch2="";
        ArrayList<String>string2=new ArrayList<>();

        for(int i=0;i<s2.length();i++){
            
            if(s2.charAt(i)!=' '){
                ch2+=s2.charAt(i);
                
            }
            else{
                string2.add(ch2);
                ch2="";
            }
        }
        if(!ch2.isEmpty())string2.add(ch2);
        HashMap<String,Integer> res=new HashMap<>();
        for(String str:string1){
            res.put(str,res.getOrDefault(str,0)+1);
        }
        for(String str:string2){
            res.put(str,res.getOrDefault(str,0)+1);
        }
        ArrayList<String>ans=new ArrayList<>();
        for(String str:res.keySet()){
            if(res.get(str)==1)ans.add(str);
        }
        return ans.toArray(new String[0]);
    }
}