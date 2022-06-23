class Solution:
    def scheduleCourse(self, courses: List[List[int]]) -> int:
        courses.sort(key=lambda x: (x[1], x[0]))
        now = 0
        arr = []
        for dura, endTime in courses:
            heapq.heappush(arr, -dura)
            now += dura
            if now > endTime:

                temp = heapq.heappop(arr)
                now += temp
        return (len(arr))

        
