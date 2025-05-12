class Solution {
    public int[] findEvenNumbers(int[] digits) {
        List<Integer> arr= new ArrayList<>();
        boolean[] checker = new boolean[1000];
        for(int i =0 ;i<digits.length;i++){
            if(digits[i]==0)continue;
            for(int j = 0; j<digits.length;j++){
                if(j ==i)continue;
                for(int p = 0; p<digits.length;p++){
                    if(p ==i || p == j|| digits[p]%2 ==1)continue;
                    int temp = 100*digits[i] + 10 * digits[j] + digits[p];
                    // System.out.println(temp+ "P : " + p);
                    checker[temp] = true;
                }
            }
        }
        for(int i = 100; i<1000;i++){
            if(checker[i]){
                arr.add(i);
            }
        }
        int[] res = new int[arr.size()];
        for(int i = 0; i<arr.size();i++){
            res[i] = arr.get(i);
        }
        return res;
    }
}