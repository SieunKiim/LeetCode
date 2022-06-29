class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int[][] result = new int[people.length][2];
//        ArrayList<int[]> result = new ArrayList<>();
        for (int[] ints : result) {
            ints[0] = -1;
            ints[1] = -1;
        }
        Arrays.sort(people,((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        }));
        result[people[0][1]] = people[0];
//        result.add(people[0]);
        for (int i = 1; i < people.length; i++) {
            int count = 0;
            for (int j = 0 ; j < people.length; j++) {
                if (people[i][0] <= result[j][0] || (result[j][0] == -1 && result[j][1] == -1)) {
                    count++;
                }
                if (count > people[i][1]) {
                    result[j] = people[i];
                    break;
                }
            }

        }

        // System.out.println("result = " + Arrays.deepToString(result));
        return result;
    }
}