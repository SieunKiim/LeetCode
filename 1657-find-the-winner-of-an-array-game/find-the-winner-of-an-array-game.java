class Solution {
    public int getWinner(int[] arr, int k) {
        int move = 1;
        int stay = 0;
        int count = 0;
        int n = arr.length;
        int biggest = arr[0];
        for(int i : arr){
            biggest = Math.max(biggest, i);
        }
        while(count < k){
            int numA = arr[stay];
            int numB = arr[move];
            if(numB == biggest) return biggest;
            if(numA >= numB){
                count += 1;
            } else {
                count = 1;
                stay= move;
            }
            move = (move+1)%n;
        }
        return arr[stay];
    }
}