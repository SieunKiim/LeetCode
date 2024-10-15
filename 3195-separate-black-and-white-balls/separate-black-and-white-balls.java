class Solution {
    // 1 : black, 0 : white
    public long minimumSteps(String s) {
        char[] arr= s.toCharArray();
        long output = 0;
        int blackStack = 0;
        int index = arr.length;
        while(index >0) {
            index -= 1;
            if(arr[index] == '0'){
                continue;
            }
            output += (arr.length - 1 - blackStack - index);
            blackStack += 1;
        }
        return output;
    }
}