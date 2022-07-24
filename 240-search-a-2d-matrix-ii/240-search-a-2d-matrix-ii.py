class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        rows = []
        for row in matrix:
            if target > row[0] and target < row[-1]:
                rows.append(row)
            elif target == row[0] or target == row[-1]:
                return True
        col = []
        if rows:
            for i in range(len(matrix[0])):
                if target > rows[0][i] and target < rows[-1][i]:
                    col.append(i)
                elif target == rows[0][i] or target == rows[-1][i]:
                    return True
            if col:
                i = j = 0
                while i < len(rows):
                    if j == col[-1]:
                        if rows[i][j] == target:
                            return True
                        j = 0
                        i += 1
                    else:
                        if rows[i][j] == target:
                            return True
                        elif rows[i][j] > target:
                            j = col[-1]
                        else:
                            j += 1
        return False