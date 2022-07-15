from collections import deque
class Solution:
    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        n = len(grid)
        m = len(grid[0])
        visited = [[0 for _ in range(m)] for _ in range(n)]
        di = [-1,0,1,0]
        dj = [0,-1,0,1]
        
        def bfs(i,j):
            count = 1
            que = deque()
            que.append([i,j])
            while que:
                ti,tj = que.popleft()
                for d in range(4):
                    ni = ti + di[d]
                    nj = tj + dj[d]
                    if 0<= ni < n and 0<= nj < m and grid[ni][nj] == 1 and visited[ni][nj] == 0:
                        visited[ni][nj] = 1
                        que.append([ni,nj])
                        count += 1
                        
            return count
        want=0
        for i in range(n):
            for j in range(m):
                if grid[i][j] == 1:
                    visited[i][j] = 1
                    want = max(want, bfs(i,j))
                    
        return want