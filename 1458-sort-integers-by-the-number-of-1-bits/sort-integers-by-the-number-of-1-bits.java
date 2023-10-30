import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int num : arr){
            int count = oneCounter(num);
            List<Integer> temp  = map.getOrDefault(count, new ArrayList<>());
            temp.add(num);
            map.put(count, temp);
        }
//        System.out.println(map);

        List<Integer> output = new ArrayList<>();

        for(List<Integer> m : map.values()){
            output.addAll(m);
        }
//        System.out.println(output);

        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            a[i] = output.get(i);
        }
        return a;
    }

    public int oneCounter(int num){
        int count = 0;
        while(num > 0){
            if(num %2 == 1) count++;
            num = num/2;
        }
        return count;
    }
}