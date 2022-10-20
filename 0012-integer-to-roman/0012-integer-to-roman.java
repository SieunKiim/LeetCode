class Solution {
    public static String intToRoman(int num) {
        int[] val = { 1000, 500, 100, 50, 10, 5, 1 };
        String[] roman = { "M", "D", "C", "L", "X", "V", "I" };
        Deque<String> que = new ArrayDeque<>();
        for (int i = 0; i < val.length; i++) {
            int temp = num / val[i];
            if (temp == 4) {
                if (!que.isEmpty()&&que.peekLast().equals(roman[i - 1])) {
                    que.pollLast();
                    que.add(roman[i]);
                    que.add(roman[i - 2]);
                } else {
                    que.add(roman[i]);
                    que.add(roman[i - 1]);
                }
            } else {
                for (int r = 0; r < temp; r++) {
                    que.add(roman[i]);
                }
            }
            num = num % val[i];
        }
        String result = "";
        while (!que.isEmpty()) {
            result += que.poll();
        }
        return result;
    }
}