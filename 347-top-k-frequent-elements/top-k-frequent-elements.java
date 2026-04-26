class Solution {
    private class Node{
        int num;
        int count;
        public Node(int num, int count){
            this.num = num;
            this.count= count;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>(); // 숫자, 카운터 
        for (int num :nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.count - o1.count);
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            pq.add(new Node(entry.getKey(), entry.getValue()));
        }
        int[] output= new int[k];
        for(int i = 0;i <k ;i++){
            output[i] = pq.poll().num;
        }
        return output;
    }
}