class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, 1 + map.getOrDefault(num, 0));
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (int n : map.keySet()) {
            pq.add(n);
        }
        int[] output = new int[k];
        for (int i = 0; i < k; i++) {
            output[i] = pq.poll();
        }
        return output;
    }
}