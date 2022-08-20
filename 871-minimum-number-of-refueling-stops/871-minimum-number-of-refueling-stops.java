class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // MAX 힙 설정
        int n = stations.length;
        int now = startFuel;
        int index = 0;
        int count = 0;
        Arrays.sort(stations, (o1,o2)-> o1[0] - o2[0]);
        while (true) {
            if (now >= target) {
                break;
            }
            while ((index <= n-1) &&(stations[index][0] <= now)) {
                heap.add(stations[index][1]);
                index += 1;
            }
            if (heap.isEmpty()) {
                return -1;
            }
            now += heap.poll();
            count += 1;
        }
        return count;
    }
}