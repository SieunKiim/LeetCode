class Solution {
    public String largestOddNumber(String num) {
        StringBuilder odd = new StringBuilder();
        int n = num.length();
        int index = -1;
        for (int i = n - 1; i >= 0; i--) {
            char now = num.charAt(i);
            if ((now - '0') % 2 == 1) {
                index = i;
                break;
            }
        }

        while (index >= 0) {
            odd.append(num.charAt(index));
            index -= 1;
        }
        odd.reverse();
        return odd.toString();
    }
}