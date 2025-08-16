class Solution {
    public int maximum69Number (int num) {
        int temp = 1000;
        while(temp >= 1){
            if((num/temp) %10 == 6){
                return num + 3 * temp;
            }
            temp = temp/10;
        }
        return num;
    }
}