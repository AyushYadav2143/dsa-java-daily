class Solution {
    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int n=nums.size();
        int count=0;
        for(int k=0;k<=n;k++){
            if(k>0 && nums.get(k-1)>=k)continue;
            if(k<n && nums.get(k)<=k)continue;
            count++;
        }
        return count;
        
    }
}