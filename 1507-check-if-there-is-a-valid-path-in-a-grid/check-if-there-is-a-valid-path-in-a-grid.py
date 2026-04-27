from typing import List
from collections import deque

class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        
        dirs = {
            1: [(0,-1),(0,1)],
            2: [(-1,0),(1,0)],
            3: [(0,-1),(1,0)],
            4: [(0,1),(1,0)],
            5: [(0,-1),(-1,0)],
            6: [(0,1),(-1,0)]
        }

        m, n = len(grid), len(grid[0])

        q = deque([(0,0)])
        visited = [[False]*n for _ in range(m)]
        visited[0][0] = True

        while q:
            r, c = q.popleft()

            if r == m-1 and c == n-1:
                return True

            for dr, dc in dirs[grid[r][c]]:

                nr, nc = r+dr, c+dc

                if not (0 <= nr < m and 0 <= nc < n):
                    continue

                if visited[nr][nc]:
                    continue

                # Neighbor must connect back
                for br, bc in dirs[grid[nr][nc]]:
                    if nr+br == r and nc+bc == c:
                        visited[nr][nc] = True
                        q.append((nr,nc))
                        break

        return False