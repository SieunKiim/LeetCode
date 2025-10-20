class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int output= 0;
        for(String s : operations){
            if(s.contains("-")){output --;}
            else {
                output++;
            }
        }
        return output;
    }
}