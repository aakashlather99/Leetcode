class Solution:
    def maxScoreWords(self, words: List[str], letters: List[str], score: List[int]) -> int:
        cnt = [0] * 26
        for c in letters:
            cnt[ord(c) - 97] += 1

        wc = []
        ws = []

        for word in words:
            f = [0] * 26
            s = 0
            for c in word:
                i = ord(c) - 97
                f[i] += 1
                s += score[i]
            wc.append(f)
            ws.append(s)

        def dfs(i):
            if i == len(words):
                return 0

            ans = dfs(i + 1)

            for j in range(26):
                if wc[i][j] > cnt[j]:
                    return ans

            for j in range(26):
                cnt[j] -= wc[i][j]

            ans = max(ans, ws[i] + dfs(i + 1))

            for j in range(26):
                cnt[j] += wc[i][j]

            return ans

        return dfs(0)