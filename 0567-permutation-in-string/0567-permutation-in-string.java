class Solution {
    int[] s1Tank;
    int[] s2Tank;

    public boolean checkInclusion(String s1, String s2) {
        s1Tank = new int[26];
        s2Tank = new int[26];
        int s1Size = s1.length();
        int s2Size = s2.length();
        if(s1Size > s2Size) return false;
        for (int i = 0; i < s1Size; i++) {
            s1Tank[s1.charAt(i) - 'a'] += 1;
            s2Tank[s2.charAt(i) - 'a'] += 1;
        }

        int[] temp = new int[26];
        for (int i = s1Size; i < s2Size; i++) {
            if(checkSame()) return true;
            int now = s2.charAt(i) - 'a';
            int last = s2.charAt(i - s1Size) - 'a';
            s2Tank[now] += 1;
            s2Tank[last] -= 1;
        }
        return checkSame();
    }
    public boolean checkSame() {
        for (int i = 0; i < 26; i++) {
            if (s1Tank[i] != s2Tank[i]) return false;
        }
        return true;
    }
}