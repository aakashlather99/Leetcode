class Solution {
   public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] p = new long[n];

        // Map boundary points to perimeter coordinate
        for (int i = 0; i < n; i++) {
            long x = points[i][0], y = points[i][1];

            if (y == 0) p[i] = x;
            else if (x == side) p[i] = side + y;
            else if (y == side) p[i] = 3L * side - x;
            else p[i] = 4L * side - y;
        }

        Arrays.sort(p);

        long lo = 0, hi = 2L * side;

        while (lo < hi) {
            long mid = (lo + hi + 1) >> 1;

            if (can(p, k, mid, 4L * side))
                lo = mid;
            else
                hi = mid - 1;
        }

        return (int) lo;
    }


    private boolean can(long[] p, int k, long d, long perimeter) {

        int n = p.length;

        long[] ext = new long[2 * n];
        for(int i=0;i<n;i++){
            ext[i]=p[i];
            ext[i+n]=p[i]+perimeter;
        }

        // next[i] = first index j with ext[j]-ext[i] >= d
        int[] next = new int[2*n];
        int j=0;

        for(int i=0;i<2*n;i++){
            if(j<i+1) j=i+1;
            while(j<2*n && ext[j]-ext[i] < d) j++;
            next[i]=j;
        }

        // binary lifting
        int LOG=6; // enough since k<=25
        int[][] jump = new int[LOG][2*n];

        for(int i=0;i<2*n;i++)
            jump[0][i]=next[i];

        for(int b=1;b<LOG;b++){
            for(int i=0;i<2*n;i++){
                int t=jump[b-1][i];
                jump[b][i]=(t<2*n)?jump[b-1][t]:2*n;
            }
        }

        for(int start=0;start<n;start++){

            int cur=start;
            int remain=k-1;

            for(int b=0;remain>0;b++){
                if((remain&1)==1){
                    cur=jump[b][cur];
                    if(cur>=start+n) break;
                }
                remain>>=1;
            }

            if(cur<start+n &&
               ext[cur]-ext[start] <= perimeter-d)
                return true;
        }

        return false;
    }
}