class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < languages.length; i++) {
            HashSet<Integer> temp = new HashSet<>();
            for (int lang : languages[i]) {
                temp.add(lang);
            }
            map.put(i + 1, temp);
        }

        Set<Integer> unreachableUsers = new HashSet<>();
        for (int[] f : friendships) {
            int a = f[0], b = f[1];
            HashSet<Integer> common = new HashSet<>(map.get(a));
            common.retainAll(map.get(b));
            if (common.isEmpty()) { // 대화 불가
                unreachableUsers.add(a);
                unreachableUsers.add(b);
            }
        }

        if (unreachableUsers.isEmpty()) return 0;

        int[] langCount = new int[n + 1];
        for (int user : unreachableUsers) {
            for (int lang : map.get(user)) {
                langCount[lang]++;
            }
        }

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int teachCount = unreachableUsers.size() - langCount[lang];
            minTeach = Math.min(minTeach, teachCount);
        }

        return minTeach;
    }
}