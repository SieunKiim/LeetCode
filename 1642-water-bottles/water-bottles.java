class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int sum = numBottles;
        while(numBottles >= numExchange){
            sum += (numBottles / numExchange);
            // System.out.println(sum);
            numBottles = (numBottles%numExchange) +(numBottles / numExchange);
        }
        return sum;
    }
}