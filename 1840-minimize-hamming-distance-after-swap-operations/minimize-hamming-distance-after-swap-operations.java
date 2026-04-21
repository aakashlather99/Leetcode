class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        int[] parent = new int[n];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;

        // Union
        for (int[] swap : allowedSwaps) {
            union(parent, rank, swap[0], swap[1]);
        }

        // Group indices by root
        HashMap<Integer, HashMap<Integer, Integer>> pool = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int root = find(parent, i);

            pool.putIfAbsent(root, new HashMap<>());
            HashMap<Integer, Integer> freq = pool.get(root);

            freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);
            freq.put(target[i], freq.getOrDefault(target[i], 0) - 1);
        }

        int diff = 0;

        for (HashMap<Integer, Integer> freq : pool.values()) {
            for (int val : freq.values()) {
                if (val > 0) diff += val; // only count unmatched
            }
        }

        return diff;
    }

    private int find(int[] parent, int x) {
        if (parent[x] != x)
            parent[x] = find(parent, parent[x]); // path compression
        return parent[x];
    }

    private void union(int[] parent, int[] rank, int a, int b) {
        int pa = find(parent, a);
        int pb = find(parent, b);

        if (pa == pb) return;

        if (rank[pa] < rank[pb]) {
            parent[pa] = pb;
        } else if (rank[pa] > rank[pb]) {
            parent[pb] = pa;
        } else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }
}

// DSU (Union-Find)
class UnionFind {
    int[] parent;

    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); 
        return parent[x];
    }

    public void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa != pb) parent[pa] = pb;
    }
    }
