class Solution {
    public int compress(char[] chars) {
        if(chars.length < 1) return 0;
        char last = chars[0];
        int count = 1;
        int index = 0;
        for(int i = 1; i< chars.length;i++){
            char now = chars[i];
            if(now == last){
                count += 1;
            } else {
                chars[index] = last;
                if (count != 1) {
                    index += 1;
                    for (int j = 0; j < String.valueOf(count).length(); j++) {
                        chars[index + j] = String.valueOf(count).charAt(j);
                    }
                }
                index += String.valueOf(count).length();
                last = now;
                count = 1;
            }
        }
        chars[index] = last;
        if (count != 1) {
            index += 1;
            for (int j = 0; j < String.valueOf(count).length(); j++) {
                chars[index + j] = String.valueOf(count).charAt(j);
            }
        }
        return index+String.valueOf(count).length();
    }
}