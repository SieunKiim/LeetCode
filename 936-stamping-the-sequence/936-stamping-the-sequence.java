class Solution {
    public int[] movesToStamp(String stamp, String target) {
        ArrayList<Integer> result = new ArrayList<>();
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();

        int stamping = 0;
        int lastStamping = 0;
        int limit = 10 * target.length();
        int m = S.length;
        int n = T.length;
        char[] Finish = new char[n];
        Arrays.fill(Finish, '?');

        while (stamping < limit) {
            lastStamping = stamping;
            for (int i = 0; i <= n - m; i++) {
                if (check(Arrays.copyOfRange(T, i, i + m), S)) {
                    stamping += 1;
                    for (int j = 0; j < m; j++) {
                        T[i + j] = '?';
                    }
                    result.add(i);
                    if (Arrays.equals(T, Finish)) {
                        Collections.reverse(result);
                        int[] re = new int[result.size()];
                        for (int t = 0; t < re.length; t++) {
                            re[t] = result.get(t);
                        }
                        return re;
                    }

                }
            }
            if (lastStamping == stamping) {
                return new int[]{};
            }
        }
        return new int[]{};

    }


    public static boolean check(char[] src, char[] stp) {
        boolean result = false;
        for (int i = 0; i < stp.length; i++) {
            if (src[i] == stp[i]) {
                result = true;
            } else if (src[i] == '?') {
                continue;
            } else {
                return false;
            }
        }
        return result;
    }
}