class Solution {
    private boolean isPrime(int x){
        if(x<2)return false;
        for(int i=2;i*i<=x;i++){
            if(x%i==0)return false;
        }
        return true;
    }
    private int findLargestPrime(int x){
        for(int i=x-1;i>=2;i--){
            if(isPrime(i))return i;
        }
        return 0;
    }
    public boolean primeSubOperation(int[] nums) {
        boolean res=false;
        nums[0]-=findLargestPrime(nums[0]);
        for(int i=1;i<nums.length;i++){
            if(nums[i]<=nums[i-1])return false;
            int prime=findLargestPrime(nums[i]-nums[i-1]);
            nums[i]-=prime;

        }
        return true;
        

        
    }
}