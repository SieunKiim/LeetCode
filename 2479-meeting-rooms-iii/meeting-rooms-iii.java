import java.util.PriorityQueue;

class Solution {
    public int mostBooked(int n, int[][] meetings) {

         Arrays.sort(meetings, (i1, i2) -> {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        });
        int[] roomCount = new int[n];
        long[] occupied = new long[n];
        for (int[] meeting : meetings) {
            int start = meeting[0];
            int end = meeting[1];
            int duration = end - start;
            long minEndTime = Long.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < n; i++) {
                if(occupied[i] <=start){
                    minEndTime = occupied[i];
                    minIndex = i;
                    break;
                }

                if (minEndTime > occupied[i]) {
                    minEndTime = occupied[i];
                    minIndex = i;
                }
            }
            if (minEndTime <= start) {
                occupied[minIndex] = end;
            } else {
                occupied[minIndex] += duration;
            }
            roomCount[minIndex] += 1;
        }

        int output = 0;
        int maxCount= 0;
        for (int i = 0; i < n; i++) {
            if (roomCount[i] > maxCount) {
                output = i;
                maxCount = roomCount[i];
            }
        }
        System.out.println(Arrays.toString(roomCount));
        return output;
    }
}