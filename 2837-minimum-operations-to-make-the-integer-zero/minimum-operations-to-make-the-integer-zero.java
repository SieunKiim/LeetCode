class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        if(num1 <= num2) return -1;
        long temp = (long) num1;
        int count = 1;

        while(temp > 0){
            temp -= (long)num2;
            int minTemp =  Long.bitCount(temp);
            System.out.println("minTemp : "+minTemp + " count : " + count + " temp : " + temp);
            if(minTemp > 0 && count >= minTemp && count <= temp) return count;
            count += 1;
        }
        return -1;
    }

    private static int minCount(int num){
        if (num <= 0){
            return -1;
        }
        int count = 0;
        while(num > 0){
            int i = 0;
            while(1<<i < num){
                i += 1;
            }
            count += 1;
            num = num - (1<<(i-1));
        }
        return count;
    }
}