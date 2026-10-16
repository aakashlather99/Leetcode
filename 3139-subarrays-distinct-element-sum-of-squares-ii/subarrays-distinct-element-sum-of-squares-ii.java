class Solution {
    static final long MOD = 1_000_000_007L;
    long[] sq, s, lazy;
    int n;

    public int sumCounts(int[] nums) {
        n = nums.length;
        sq = new long[4 * n];
        s = new long[4 * n];
        lazy = new long[4 * n];
        Map<Integer, Integer> last = new HashMap<>();
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int p = last.getOrDefault(nums[i], -1);
            update(1, 0, n - 1, p + 1, i);
            last.put(nums[i], i);
            ans = (ans + sq[1]) % MOD;
        }
        return (int) ans;
    }

    void apply(int node, int l, int r, long v) {
        long len = r - l + 1;
        sq[node] = (sq[node] + 2 * v * s[node] + v * v * len) % MOD;
        s[node] = (s[node] + v * len) % MOD;
        lazy[node] += v;
    }

    void push(int node, int l, int r) {
        if (lazy[node] == 0 || l == r) return;
        int m = (l + r) / 2;
        apply(node * 2, l, m, lazy[node]);
        apply(node * 2 + 1, m + 1, r, lazy[node]);
        lazy[node] = 0;
    }

    void update(int node, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, 1);
            return;
        }
        push(node, l, r);
        int m = (l + r) / 2;
        update(node * 2, l, m, ql, qr);
        update(node * 2 + 1, m + 1, r, ql, qr);
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
        s[node] = (s[node * 2] + s[node * 2 + 1]) % MOD;
    }
}