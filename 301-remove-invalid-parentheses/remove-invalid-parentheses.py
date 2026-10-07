class Solution:
    def removeInvalidParentheses(self, s: str) -> list[str]:
        left = right = 0

        for c in s:
            if c == '(':
                left += 1
            elif c == ')':
                if left:
                    left -= 1
                else:
                    right += 1

        res = set()

        def dfs(i, balance, l, r, path):
            if i == len(s):
                if balance == 0 and l == 0 and r == 0:
                    res.add(''.join(path))
                return

            c = s[i]

            if c == '(':
                if l:
                    dfs(i + 1, balance, l - 1, r, path)
                path.append(c)
                dfs(i + 1, balance + 1, l, r, path)
                path.pop()

            elif c == ')':
                if r:
                    dfs(i + 1, balance, l, r - 1, path)
                if balance:
                    path.append(c)
                    dfs(i + 1, balance - 1, l, r, path)
                    path.pop()

            else:
                path.append(c)
                dfs(i + 1, balance, l, r, path)
                path.pop()

        dfs(0, 0, left, right, [])
        return list(res)