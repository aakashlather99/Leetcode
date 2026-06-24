class Solution:
    def partition(self, s: str) -> List[List[str]]:
        res = []
        
        def dfs(start, path):
            if start == len(s):
                res.append(path[:])
                return
            
            for i in range(start, len(s)):
                sub = s[start:i+1]
                if sub == sub[::-1]:
                    path.append(sub)
                    dfs(i + 1, path)
                    path.pop()
                    
        dfs(0, [])
        return res