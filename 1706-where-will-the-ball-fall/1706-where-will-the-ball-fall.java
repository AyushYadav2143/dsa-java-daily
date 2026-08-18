class Solution {
    public int[] findBall(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[]ans=new int[n];
        for(int ball=0;ball<n;ball++){
            int col=ball;
            for(int row=0;row<m;row++){
                if(grid[row][col]==1){
                    if(col+1>=n || grid[row][col+1]==-1){
                        col=-1;
                        break;
                    }
                    col++;
                }
                else{
                    if(col-1<0 || grid[row][col-1]==1){
                        col=-1;
                        break;
                    }
                    col--;
                }
            }
            ans[ball]=col;
        }
        return ans;

        
    }
}