class Solution {

    public String findLexSmallestString(String s, int a, int b) {
        HashSet<String> set = new HashSet<>();
        Deque<String> que = new ArrayDeque<>();
        String min = s;
        int n = s.length();
        que.add(s);
        set.add(s);
        while(!que.isEmpty()){
            String now = que.poll();
            // System.out.println(now);
            min = (now.compareTo(min) < 0) ? now : min;
            StringBuilder sb = new StringBuilder(now);
            for(int i =0 ;i<b;i++){
                char first = sb.charAt(n-1);
                // 2. 첫 번째 문자 삭제
                sb.deleteCharAt(n-1);
                // 3. 마지막에 추가
                sb.insert(0,first);
            }
            
            String temp1 = sb.toString();
            if(!set.contains(temp1)) {
                que.add(temp1);
                set.add(temp1);
            }

            char[] charArr = now.toCharArray();
            for(int i = 1; i<charArr.length;i +=2){
                char nowChar = charArr[i];
                charArr[i] = (char)((nowChar -'0'+ a) % 10 + '0');
            }
            String temp2 = new String(charArr);
            if(!set.contains(temp2)) {
                que.add(temp2);
                set.add(temp2);
            }
        }
        return min;
    }
    
}