class Solution {

    public int[] avoidFlood(int[] rains) {
                TreeSet<Integer> zeroPoint = new TreeSet<>();
                HashMap<Integer, Integer> rainMap = new HashMap<>();
                int[] output = new int[rains.length];
                Arrays.fill(output, 1);

                for (int i = 0; i < rains.length; i++) {
                    if (rains[i] == 0) {
                        zeroPoint.add(i);


                    } else {
                        output[i] = -1;
                        

                        if (rainMap.containsKey(rains[i])) {
                            int lastPoint = rainMap.get(rains[i]);
                            Integer nextZeroPoint = zeroPoint.higher(lastPoint);
                            if (nextZeroPoint == null || nextZeroPoint > i)
                                return new int[] {};
                            output[nextZeroPoint] = rains[i];
                            zeroPoint.remove(nextZeroPoint);
                        }
                        rainMap.put(rains[i], i);
                    }
                }
                return output;
            }
}