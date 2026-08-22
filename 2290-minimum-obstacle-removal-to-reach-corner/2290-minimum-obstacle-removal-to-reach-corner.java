class Solution {
    public int minimumObstacles(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[][]dist=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=Integer.MAX_VALUE;
            }
        }
        Deque<int[]>deque=new ArrayDeque<>();
        dist[0][0]=0;
        deque.addFirst(new int[]{0,0});
        int[][]directions={
            {1,0},{-1,0},{0,1},{0,-1}
        };
        while(!deque.isEmpty()){
            int[]current=deque.removeFirst();
            int row=current[0];
            int col=current[1];
            for(int[]dir:directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(newRow<0|| newRow>=m || newCol<0 || newCol>=n)continue;
                int newCost=dist[row][col]+grid[newRow][newCol];
                if(newCost<dist[newRow][newCol]){
                    dist[newRow][newCol]=newCost;
                    if(grid[newRow][newCol]==0){
                        deque.addFirst(new int[]{newRow,newCol});
                    }
                    else{
                        deque.addLast(new int[]{newRow,newCol});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}