class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        int numOfBuildings = buildings.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b){
                return b[2]-a[2];
            }
        });
        
        int x = numOfBuildings==0?Integer.MAX_VALUE:buildings[0][0],next=0;
        pq.offer(new int[]{Integer.MIN_VALUE,Integer.MAX_VALUE,0});
        
        while(x!=Integer.MAX_VALUE || next<numOfBuildings || pq.size()>1){
            while(pq.size()>1 && pq.peek()[1]<=x){
                pq.poll();
            }
            
            while(next<numOfBuildings && x==buildings[next][0]) pq.offer(buildings[next++]);
            
            if(ans.size()==0 || pq.peek()[2]!=ans.get(ans.size()-1).get(1)) ans.add(
                Arrays.asList(new Integer[]{x,pq.peek()[2]})
            );
            
            // The next x position is either when the prev peak goes out of bound
            // or the next building comes into picture(that may or may not change the skyline)
            x = Math.min(pq.peek()[1],next>=numOfBuildings?Integer.MAX_VALUE:buildings[next][0]);
        }
        
        return ans;
        
        
        // List<List<Integer>> result = new ArrayList<>();
        // List<int[]> height = new ArrayList<>();
        // for(int[] b:buildings) {
        //     height.add(new int[]{b[0], -b[2]});
        //     height.add(new int[]{b[1], b[2]});
        // }
        // Collections.sort(height, (a, b) -> {
        //         if(a[0] != b[0]) 
        //             return a[0] - b[0];
        //         return a[1] - b[1];
        // });
        // Queue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        // pq.offer(0);
        // int prev = 0;
        // for(int[] h:height) {
        //     if(h[1] < 0) {
        //         pq.offer(-h[1]);
        //     } else {
        //         pq.remove(h[1]);
        //     }
        //     int cur = pq.peek();
        //     if(prev != cur) {
        //         List<Integer>temp = new ArrayList<>();
        //         temp.add(h[0]);
        //         temp.add(cur);
        //         result.add(temp);
        //         prev = cur;
        //     }
        // }
        // return result;
    }
}