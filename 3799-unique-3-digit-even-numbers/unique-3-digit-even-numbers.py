class Solution:
    def totalNumbers(self, digits: List[int]) -> int:
        cnt = [0] * 10
        for d in digits:
            cnt[d] += 1

        ans = 0

        for a in range(1, 10):
            for b in range(10):
                for c in range(0, 10, 2):
                    if a == b == c:
                        if cnt[a] >= 3:
                            ans += 1
                    elif a == b:
                        if cnt[a] >= 2 and cnt[c] >= 1:
                            ans += 1
                    elif a == c:
                        if cnt[a] >= 2 and cnt[b] >= 1:
                            ans += 1
                    elif b == c:
                        if cnt[b] >= 2 and cnt[a] >= 1:
                            ans += 1
                    elif cnt[a] >= 1 and cnt[b] >= 1 and cnt[c] >= 1:
                        ans += 1

        return ans