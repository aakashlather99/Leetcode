class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            int count = 0;

            for (int[] p : points) {
                int dx = p[0] - x;
                int dy = p[1] - y;

                if (dx * dx + dy * dy <= r * r) {
                    count++;
                }
            }

            ans[i] = count;
        }

        return ans;
    }
}