class Solution {
    public String removeStars(String s) {
        Deque<Character> que = new ArrayDeque<>();
        for(int i= 0 ;i< s.length();i++){
            char now = s.charAt(i);
            if(now == '*'){
                que.pollLast();
            } else{
                que.add(now);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!que.isEmpty()){
            sb.append(que.poll());
        }
        return sb.toString();
    }
}