class Solution:
    def sortableIntegers(self, nums: list[int]) -> int:
        n = len(nums)
        target = sorted(nums)
        ans = 0

        for k in range(1, n + 1):
            if n % k:
                continue

            ok = True

            for start in range(0, n, k):
                a = nums[start:start + k]
                b = target[start:start + k]

                if sorted(a) != b:
                    ok = False
                    break

                descents = sum(a[i] > a[i + 1] for i in range(k - 1))
                if descents > 1 or (descents == 1 and a[-1] > a[0]):
                    ok = False
                    break

            if ok:
                ans += k

        return ans