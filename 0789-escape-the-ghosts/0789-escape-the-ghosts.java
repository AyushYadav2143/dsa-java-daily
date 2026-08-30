class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int x1=target[0];
        int y1=target[1];
        int ownDist=Math.abs(x1-0)+Math.abs(y1-0);
        for(int i=0;i<ghosts.length;i++){
            int x2=ghosts[i][0];
            int y2=ghosts[i][1];
            int dist=Math.abs(x1-x2)+Math.abs(y2-y1);
            if(dist<=ownDist)return false;

        }
        return true;
       
        
    }
}