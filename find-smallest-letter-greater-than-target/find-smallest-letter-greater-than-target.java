class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int gap = Integer.MAX_VALUE;
        char output = letters[0];
        for(int i =0 ;i < letters.length;i++){
            int temp = letters[i] - target;
            if(temp > 0 && temp < gap){
                gap = temp;
                output = letters[i];
            }
            // System.out.println((char)(temp + target));
        }
        return output;
    }
}