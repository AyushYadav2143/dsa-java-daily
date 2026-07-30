class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m=mat.length;
        int n=mat[0].length;
        if(m*n==r*c){
            int[][]newMatrix=new int[r][c];
            for(int i=0;i<m*n;i++){
                newMatrix[i/c][i%c]=mat[i/n][i%n];
            }
            return newMatrix;
        }
        return mat;
        
    }
}