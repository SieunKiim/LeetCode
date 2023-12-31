class Solution {

    public int maxLengthBetweenEqualCharacters(String s) {
        int output = -1;
        HashMap<Character, Integer> map = new HashMap<>();
        int n = s.length();
        if (n < 2) {
            return -1;
        }
        for (int i = 0; i < n; i++) {
            char now = s.charAt(i);
            if (!map.containsKey(now)) {
                map.put(now, i);
            } else {
                Integer lastPosition = map.get(now);
                output = Math.max(output, i - lastPosition - 1);
            }
        }
        return output;
    }
}