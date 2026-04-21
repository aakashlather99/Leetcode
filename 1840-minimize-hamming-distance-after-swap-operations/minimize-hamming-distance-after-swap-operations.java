class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;

        UnionFind uf = new UnionFind(n);

        // Step 1: Build components
        for (int[] swap : allowedSwaps) {
            uf.union(swap[0], swap[1]);
        }

        // Step 2: Group indices by parent
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int parent = uf.find(i);
            map.computeIfAbsent(parent, k -> new ArrayList<>()).add(i);
        }

        int result = 0;

        // Step 3: Process each component
        for (List<Integer> group : map.values()) {
            Map<Integer, Integer> freq = new HashMap<>();

            // count source values
            for (int idx : group) {
                freq.put(source[idx], freq.getOrDefault(source[idx], 0) + 1);
            }

            // match with target
            for (int idx : group) {
                if (freq.getOrDefault(target[idx], 0) > 0) {
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                } else {
                    result++; // mismatch
                }
            }
        }

        return result;
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
