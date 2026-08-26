class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        HashMap<Integer,Integer>internalEdges=new HashMap<>();
        for(List<Integer>arr:wall){
            int position=0;
            for(int i=0;i<arr.size()-1;i++){
                position+=arr.get(i);
                internalEdges.put(position,internalEdges.getOrDefault(position,0)+1);
            }
            
        }
        int maxFreq=0;
        for(int freq:internalEdges.values()){
            maxFreq=Math.max(maxFreq,freq);
        }
        return wall.size()-maxFreq;
        
    }
}