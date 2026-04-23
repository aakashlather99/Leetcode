class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        groups = defaultdict(list)

        # Store indices for each value
        for i, num in enumerate(nums):
            groups[num].append(i)

        ans = [0] * len(nums)

        for pos in groups.values():
            m = len(pos)

            # Prefix sum of indices
            prefix = [0] * m
            prefix[0] = pos[0]

            for i in range(1, m):
                prefix[i] = prefix[i - 1] + pos[i]

            for i, idx in enumerate(pos):

                left = 0 if i == 0 else i * idx - prefix[i - 1]

                right = 0 if i == m - 1 else \
                    (prefix[-1] - prefix[i]) - (m - i - 1) * idx

                ans[idx] = left + right

        return ans