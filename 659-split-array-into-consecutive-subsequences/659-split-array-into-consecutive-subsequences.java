import java.lang.Math;
class Solution {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> dict = new HashMap<>();
        HashMap<Integer, Integer> check = new HashMap<>();
        for (int i : nums) {
            dict.put(i, dict.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (dict.get(i) == 0) {
                continue;
            } else if (check.getOrDefault(i, 0) > 0) {
                check.put(i, check.get(i) - 1);
                check.put(i + 1, check.getOrDefault(i + 1, 0) + 1);
            } else if (dict.getOrDefault(i + 1, 0) > 0 && dict.getOrDefault(i + 2, 0) > 0) {
                dict.put(i + 1, dict.get(i + 1) - 1);
                dict.put(i + 2, dict.get(i + 2) - 1);
                check.put(i + 3, check.getOrDefault(i + 3, 0) + 1);
            } else {
                return false;
            }
            dict.put(i, dict.get(i) - 1);
        }
        return true;
        // HashMap<Integer, Integer> dict = new HashMap<>();
        // for (int i = 0; i < nums.length; i++) {
        //     dict.put(nums[i], dict.getOrDefault(nums[i], 0) + 1);
        // }
        // int big = 0;
        // int start = -100000;
        // for (Map.Entry<Integer, Integer> d : dict.entrySet()) {
        //     big = Math.max(big, d.getValue());
        //     if (start == -100000) {
        //         start = d.getKey();
        //     } else {
        //         start += 1;
        //         if (d.getKey() != start) {
        //             return false;
        //         }
        //     }
        // }
        // Queue<Integer> queue = new LinkedList<>();
        // int last = 0;
        // int size = dict.size();
        // if (nums.length >= big * 3) {
        //     for (Map.Entry<Integer, Integer> d : dict.entrySet()) {
        //         if (queue.isEmpty()) {
        //             last = d.getValue();
        //             for (int i = 0; i < d.getValue(); i++) {
        //                 queue.add(d.getKey());
        //             }
        //         } else {
        //             if (d.getValue() > last) {
        //                 for (int i = 0; i < d.getValue()-last; i++) {
        //                     queue.add(d.getKey());
        //                 }
        //             } else if (d.getValue() < last) {
        //                 for (int i = 0; i < last - d.getValue(); i++) {
        //                     int temp = queue.poll();
        //                     int len = d.getKey() - temp + 1;
        //                     if (len < 3) {
        //                         return false;
        //                     }
        //                 }
        //             }
        //             last = d.getValue();
        //         }
        //     }
        //     if (size - queue.poll()+1 < 3) {
        //         return false;
        //     }
        // } else {
        //     return false;
        // }
        // return true;
    }
}