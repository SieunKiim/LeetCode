class Solution:
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        i=0
        j=0
        m=len(matrix)
        n=len(matrix[0])
        while(i<m):
            if(max(matrix[i]) >= target and min(matrix[i]) <= target):
                if (target in matrix[i]): 
                    return True
            i+=1
        return False