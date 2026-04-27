import java.util.*;

class Solution {

    // Directions: up, down, left, right
    int[][] dirs = {
        {-1,0},{1,0},{0,-1},{0,1}
    };

    // For each street type, allowed directions
    int[][][] roads = {
        {},
        {{0,-1},{0,1}},           //1 left-right
        {{-1,0},{1,0}},           //2 up-down
        {{0,-1},{1,0}},           //3 left-down
        {{0,1},{1,0}},            //4 right-down
        {{0,-1},{-1,0}},          //5 left-up
        {{0,1},{-1,0}}            //6 right-up
    };

    public boolean hasValidPath(int[][] grid) {

        int m = grid.length, n = grid[0].length;

        boolean[][] vis = new boolean[m][n];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0,0});
        vis[0][0]=true;

        while(!q.isEmpty()){

            int[] cur=q.poll();
            int r=cur[0], c=cur[1];

            if(r==m-1 && c==n-1)
                return true;

            for(int[] d : roads[grid[r][c]]){

                int nr=r+d[0];
                int nc=c+d[1];

                if(nr<0 || nc<0 || nr>=m || nc>=n || vis[nr][nc])
                    continue;

                // check neighbor connects back
                for(int[] back : roads[grid[nr][nc]]){

                    if(nr+back[0]==r && nc+back[1]==c){
                        vis[nr][nc]=true;
                        q.offer(new int[]{nr,nc});
                        break;
                    }
                }
            }
        }

        return false;
    }
}