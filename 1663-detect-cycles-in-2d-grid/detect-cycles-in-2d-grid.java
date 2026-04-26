class Solution {

    public boolean containsCycle(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int[] parent = new int[m*n];
        int[] rank = new int[m*n];

        for(int i=0;i<m*n;i++)
            parent[i]=i;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                // check right
                if(j+1<n && grid[i][j]==grid[i][j+1]){
                    if(!union(parent,rank,
                            i*n+j,
                            i*n+j+1))
                        return true;
                }

                // check down
                if(i+1<m && grid[i][j]==grid[i+1][j]){
                    if(!union(parent,rank,
                            i*n+j,
                            (i+1)*n+j))
                        return true;
                }
            }
        }

        return false;
    }

    private int find(int[] parent,int x){
        while(parent[x]!=x){
            parent[x]=parent[parent[x]];
            x=parent[x];
        }
        return x;
    }

    // returns false if already connected => cycle
    private boolean union(int[] parent,int[] rank,int a,int b){

        int pa=find(parent,a);
        int pb=find(parent,b);

        if(pa==pb)
            return false;

        if(rank[pa]<rank[pb]){
            parent[pa]=pb;
        }
        else if(rank[pa]>rank[pb]){
            parent[pb]=pa;
        }
        else{
            parent[pb]=pa;
            rank[pa]++;
        }

        return true;
    }
}