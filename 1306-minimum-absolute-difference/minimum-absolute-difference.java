class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> output = new ArrayList<>();
        int last = arr[0];
        int gap = Integer.MAX_VALUE;
        for(int i = 1; i< arr.length;i++){
            int tempGap = arr[i]-last;
            // System.out.println("i : "+ i + " tempGap : " + tempGap); 
            if(tempGap < gap){
                output = new ArrayList<>();
                output.add(new ArrayList<>(List.of(last, arr[i])));
                gap = tempGap;
            } else if (tempGap == gap){
                output.add(new ArrayList<>(List.of(last, arr[i])));
            } 
            last = arr[i];
        }
        return output;
    }
}