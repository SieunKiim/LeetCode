class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        List<Integer> t = new ArrayList<>();
        for(int n : nums){
            t.add(n);
        }
        return temp(t);
    }

    private List<Integer> temp(List<Integer> nums){
        List<Integer> output = new ArrayList<>();
        long val = nums.get(0);
        int index = 1;
        while(index < nums.size()){
            int temp = gcd((int)val, nums.get(index));
            // System.out.println("temp : " + temp);
            if(temp != 1){
                val = val * nums.get(index) / temp;

                while(!output.isEmpty()){
                    int temp2 = gcd((int)val, output.get(output.size()-1));
                    if(temp2 != 1){
                        val = val * output.get(output.size()-1) / temp2;
                        output.remove(output.size()-1);
                    }else {
                        break;
                    }
                }
            } else {
                output.add((int)val);
                // System.out.println("index : " +index + ", val : " + val);
                val = nums.get(index);
            }
            index += 1;
        }
        output.add((int)val);
        return output;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}