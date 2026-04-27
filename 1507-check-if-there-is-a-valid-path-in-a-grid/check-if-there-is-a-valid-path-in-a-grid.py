class Solution:
    def hasValidPath(self, grid):

        dirs = {
            1: [(0,-1),(0,1)],
            2: [(-1,0),(1,0)],
            3: [(0,-1),(1,0)],
            4: [(0,1),(1,0)],
            5: [(0,-1),(-1,0)],
            6: [(0,1),(-1,0)]
        }

        m,n=len(grid),len(grid[0])

        vis=[[False]*n for _ in range(m)]

        q=deque([(0,0)])
        vis[0][0]=True

        while q:

            r,c=q.popleft()

            if r==m-1 and c==n-1:
                return True

            for dr,dc in dirs[grid[r][c]]:

                nr,nc=r+dr,c+dc

                if not(0<=nr<m and 0<=nc<n) or vis[nr][nc]:
                    continue

                for br,bc in dirs[grid[nr][nc]]:
                    if nr+br==r and nc+bc==c:
                        vis[nr][nc]=True
                        q.append((nr,nc))
                        break

        return False