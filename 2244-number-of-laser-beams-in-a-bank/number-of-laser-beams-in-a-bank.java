class Solution {
    public int numberOfBeams(String[] bank) {
        int lastVal = 0;
        int output = 0;
        for(String s : bank){
            int now = getDeviceCount(s);
            if(now != 0){
                output += lastVal * now;
                lastVal = now;
            }
        }
        return output;
    }

    public int getDeviceCount(String s){
        int count = 0;
        for(int i = 0; i < s.length();i++){
            char now = s.charAt(i);
            if(now == '1'){
                count += 1;
            }
        }
        return count;
    }
}