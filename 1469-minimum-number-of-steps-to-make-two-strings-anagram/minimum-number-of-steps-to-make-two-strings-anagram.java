class Solution {
    public int minSteps(String s, String t) {
        int n = s.length();
        int[] arr = new int[26];
        for(int i =0 ;i< n;i++){
            arr[s.charAt(i)-'a'] += 1;
        }

        System.out.println(Arrays.toString(arr));

        for(int i =0 ;i< n;i++){
            if(arr[t.charAt(i)-'a'] > 0)
                arr[t.charAt(i)-'a'] -= 1;
        }

                System.out.println(Arrays.toString(arr));

        int output = 0;
        for(int i = 0 ;i<26 ;i++){
            output += arr[i];
        }
        return output;
    }
}