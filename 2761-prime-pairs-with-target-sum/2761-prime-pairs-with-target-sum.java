class Solution {
    private boolean isPrime(int num){
        if(num<2)return false;
        for(int i=2;i*i<=num;i++){
            if(num%i==0)return false;
        }
        return true;
    }
    public List<List<Integer>> findPrimePairs(int n) {
        List<List<Integer>> res=new ArrayList<>();
        for(int i=2;i<=n/2;i++){
            if(isPrime(i) && isPrime(n-i)){
                List<Integer>temp=new ArrayList<>();
                temp.add(i);
                temp.add(n-i);
                res.add(temp);
            }
           
        }
        return res;
        
    }
}