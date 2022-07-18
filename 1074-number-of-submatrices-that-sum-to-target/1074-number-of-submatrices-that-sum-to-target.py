class Solution:
    def numSubmatrixSumTarget(self, matrix: List[List[int]], target: int) -> int:
#         result = 0
#         n = len(matrix)
#         m = len(matrix[0])
#         board = [[0 for _ in range(m+1)] for _ in range(n+1)]
#         board[1][1] = matrix[0][0]
#         for i in range(1,n+1):
#             temp = 0
#             for j in range(1,m+1):
#                 # if matrix[i-1][j-1]:
#                     # result += 1
#                 temp += matrix[i-1][j-1]
#                 board[i][j] = temp + board[i-1][j]
                    
#         Ci = list(itertools.combinations(list(cn for cn in range(n+1)), 2))
#         Cj = list(itertools.combinations(list(cm for cm in range(m+1)), 2))

#         for i1, i2 in Ci:
#             for j1, j2 in Cj:
#                 if board[i1][j1] + board[i2][j2] - (board[i1][j2] + board[i2][j1]) == target:
#                     result += 1
#         return(result)
        m, n = len(matrix), len(matrix[0])
        for row in matrix:
            for i in range(n - 1):
                row[i + 1] += row[i]
        res = 0
        for i in range(n):
            for j in range(i, n):
                c = collections.defaultdict(int)
                cur, c[0] = 0, 1
                for k in range(m):
                    cur +=matrix[k][j] - (matrix[k][i - 1] if i > 0 else 0)
                    res += c[cur - target]
                    c[cur] += 1
        return res
                
        # for i in range(n+1):
        #     print(board[i])
        # print("")
# 1 2 3
# 4 5 6
# 7 8 9

# 1   3   6
# 5   12  21
# 12  20  45


# [0,1,0,0,1]
# [0,0,1,1,1]
# [1,1,1,0,1]
# [1,1,0,1,1]
# [0,1,1,0,0]
# 1