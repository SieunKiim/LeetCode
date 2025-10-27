class Solution {
    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int m = bank[0].length();
        int last = 0;
        int sum = 0;
        for(String s : bank){
            char[] arr = s.toCharArray();
            int temp = countDevice(arr);
            if(temp == 0) continue;
            if(last == 0){
                last = temp;
            } else {
                sum += last * temp;
                last = temp;
            }
        }
        return sum;
    }

    private int countDevice(char[] arr){
        int output = 0;
        for(char a : arr){
            if(a == '1')output += 1;
        }
        return output;
    }
}