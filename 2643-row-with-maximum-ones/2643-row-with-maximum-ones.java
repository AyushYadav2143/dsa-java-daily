class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOnesIndex=0;
        int maxOnes=0;
        for(int i=0;i<mat.length;i++){
            int ones=0;
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==1)ones++;
            }
            if(ones>maxOnes){
                maxOnesIndex=i;
                maxOnes=ones;
            }
        }
        return new int[]{maxOnesIndex,maxOnes};
        
    }
}