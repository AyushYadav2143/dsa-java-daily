class Solution {
    public int dominantIndex(int[] nums) {
        int largest=nums[0];
        int index=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>largest){
                largest=nums[i];
                index=i;
            }
            
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]==largest)continue;
            int num=nums[i];
            if(largest<2*num)return -1;
            
        }
        return index;
        
    }
}