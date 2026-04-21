class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        // Build DSU
        for (int[] swap : allowedSwaps) {
            union(parent, swap[0], swap[1]);
        }

        // Group elements by root
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);

            map.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> freq = map.get(root);

            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
            freq.put(target[i], freq.getOrDefault(target[i], 0) - 1);
        }

        int ans = 0;

        // Count mismatches
        for (HashMap<Integer, Integer> freq : map.values()) {
            for (int val : freq.values()) {
                if (val > 0) ans += val;
            }
        }

        return ans;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x) {
            parent[x] = find(parent, parent[x]); // path compression
        }
        return parent[x];
    }

    private void union(int[] parent, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa != pb) {
            parent[pa] = pb;
}}}