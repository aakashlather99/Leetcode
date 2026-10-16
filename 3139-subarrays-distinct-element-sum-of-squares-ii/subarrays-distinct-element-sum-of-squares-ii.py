class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        MOD = 10**9 + 7
        n = len(nums)
        tree = [0] * (4 * n)
        lazy = [0] * (4 * n)
        last = {}
        ans = 0

        def apply(node, l, r, v):
            length = r - l + 1
            tree[node] = (tree[node] + 2 * v * tree_sum[node] + v * v * length) % MOD

        tree_sum = [0] * (4 * n)

        def apply(node, l, r, v):
            length = r - l + 1
            tree[node] = (tree[node] + 2 * v * tree_sum[node] + v * v * length) % MOD
            tree_sum[node] = (tree_sum[node] + v * length) % MOD
            lazy[node] += v

        def push(node, l, r):
            if lazy[node] == 0 or l == r:
                return
            m = (l + r) // 2
            v = lazy[node]
            apply(node * 2, l, m, v)
            apply(node * 2 + 1, m + 1, r, v)
            lazy[node] = 0

        def update(node, l, r, ql, qr, v):
            if ql > r or qr < l:
                return
            if ql <= l and r <= qr:
                apply(node, l, r, v)
                return
            push(node, l, r)
            m = (l + r) // 2
            update(node * 2, l, m, ql, qr, v)
            update(node * 2 + 1, m + 1, r, ql, qr, v)
            tree[node] = (tree[node * 2] + tree[node * 2 + 1]) % MOD
            tree_sum[node] = (tree_sum[node * 2] + tree_sum[node * 2 + 1]) % MOD

        for i, x in enumerate(nums):
            p = last.get(x, -1)
            update(1, 0, n - 1, p + 1, i, 1)
            last[x] = i
            ans = (ans + tree[1]) % MOD

        return ans

