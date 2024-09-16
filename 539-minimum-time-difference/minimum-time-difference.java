class Solution {
    public int findMinDifference(List<String> timePoints) {
        PriorityQueue<Integer> pq = new PriorityQueue();
        for(String s : timePoints){
            pq.add(converter(s));
        }
        pq.add(60 * 24 + pq.peek());
        int last = pq.poll();
        int output = Integer.MAX_VALUE;
        while(!pq.isEmpty()){
            output= Math.min(output, pq.peek() - last);
            last = pq.poll();
        }
        return output;
    }

    private int converter(String raw){
        String[] temp = raw.split(":");
        int hour = Integer.parseInt(temp[0]);
        int minute = Integer.parseInt(temp[1]);
        return hour * 60 + minute;
    }
}