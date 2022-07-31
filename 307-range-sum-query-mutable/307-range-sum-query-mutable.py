class NumArray:
    seg_tree = [0]
    start = -1
    end = -1
    gnums = []
    def __init__(self, nums: List[int]):
        global start
        global end
        global gnums
        global seg_tree
        gnums = nums
        seg_tree = [0] * (len(nums) * 4)
        start = 0
        end = len(nums)-1
        def init(start, end, target):
            if start == end:
                seg_tree[target] = nums[start]
                return seg_tree[target]
            mid = (start + end) //2
            seg_tree[target] = init(start,mid,target*2) + init(mid+1,end,target*2 + 1)
            return seg_tree[target]
        init(start, end, 1)
        # print(seg_tree)
        # return seg_tree


    def update(self, index: int, val: int) -> None:
        diff = val - gnums[index]
        gnums[index] = val
        def Update(start,end,target,index, val):
            if index < start or index > end:
                return
            seg_tree[target] += val
            if start == end:
                return
            mid = (start+end)//2
            Update(start, mid, target*2, index, val)
            Update(mid+1, end, target*2 +1, index, val)
        
        Update(0, len(gnums)-1, 1, index, diff)

    def sumRange(self, left: int, right: int) -> int:
        def Sum(start, end, target, left, right):
            if left > end or right < start:
                return 0
            if left <= start and end<=right:
                return seg_tree[target]
            mid = (start+end)//2
            return Sum(start, mid, target*2, left,right) + Sum(mid+1, end, target*2 +1, left,right)
        return Sum(0,len(gnums)-1,1, left,right)


# Your NumArray object will be instantiated and called as such:
# obj = NumArray(nums)
# obj.update(index,val)
# param_2 = obj.sumRange(left,right)