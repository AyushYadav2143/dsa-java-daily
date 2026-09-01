class Solution {
    private int reverse(int n){
        int rev=0;
        while(n>0){
            int digit=n%10;
            rev=rev*10+digit;
            n/=10;
        }
        return rev;    
    }

    public boolean sumOfNumberAndReverse(int num) {
        for(int i=0;i<=num;i++){
            int num1=i;
            int num2=reverse(i);
            if(num1+num2==num)return true;

        }
        return false;
    }
}