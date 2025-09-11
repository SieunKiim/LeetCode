class Solution {
    public String sortVowels(String s) {
        PriorityQueue<Character> pq = new PriorityQueue<>();
        char[] charArr = s.toCharArray();
        HashSet<Character> set = new HashSet<>(Arrays.asList('a','e','i','o','u'));
        for(int i = 0; i < s.length(); i++){
            char now = charArr[i];
            if(set.contains(Character.toLowerCase(now))){
                pq.add(now);
                charArr[i] = '.';
            }
        }
        for(int i =0 ;i<charArr.length;i++){
            if(charArr[i] == '.'){
                charArr[i] = pq.poll();
            }
        }
        return new  String(charArr);
    }
}