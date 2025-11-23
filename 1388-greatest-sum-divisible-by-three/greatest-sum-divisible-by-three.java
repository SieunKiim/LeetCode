class Solution {
    public int maxSumDivThree(int[] nums) {
        PriorityQueue<Integer> one = new PriorityQueue<>();
        PriorityQueue<Integer> two = new PriorityQueue<>();
        int sum = 0;
        for(int i =0; i<nums.length;i++){
            int now= nums[i];
            sum += now;
            if(now%3 == 1) one.add(now);
            else if(now%3 == 2) two.add(now);
        }

        if(sum%3 == 0) return sum;
        else if(sum%3 == 1){
            if(one.size() == 0){
                return sum - (two.poll() + two.poll());
            }
            if( (two.size() <= 1 || one.peek() < two.peek())){
                return sum - one.poll();
            }
            return sum - Math.min(one.poll(), two.poll() + two.poll());
        } else {
            if(two.size() == 0){
                return sum - (one.poll() + one.poll());
            }
            if( (one.size() <= 1 || one.peek() > two.peek())){
                return sum - two.peek();
            }
            return sum- Math.min(one.poll() + one.poll(), two.poll());
        }
    }
}