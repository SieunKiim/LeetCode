class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        int left = 0;
        char[] arr = s.toCharArray();
        int right = s.length()-1;
        while(left<= right){
            while(left <right && !set.contains(arr[left])){
                left += 1;
            }
            while(right > left && !set.contains(arr[right])){
                right -=1;
            }
            char temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            left +=1;
            right -=1;
        }
        return new String(arr);
    }
}