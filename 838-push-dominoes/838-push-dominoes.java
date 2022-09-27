class Solution {
    public String pushDominoes(String dominoes) {
        String output = "";
        int size = dominoes.length();
        
        int[] check = new int[size];
        String[] result = new String[size];
        Arrays.fill(check, Integer.MAX_VALUE);
        for (int i =0 ; i< size; i ++){
            if(dominoes.charAt(i) == 'R'){
                result[i] = "R";
                check[i] = 1;
            } else if (dominoes.charAt(i) == '.') {
                if(0<i && check[i-1] > 0 && check[i-1] < Integer.MAX_VALUE){
                    check[i] = check[i-1] + 1;
                    result[i] = "R";
                } else{
                    result[i] = ".";
                }
            } else { // == 'L'
                int target = 1;
                int index = i;
                while(index >= 0 && check[index] > target){
                    result[index] = "L";
                    if(index >= 1 && result[index-1].equals("L")) break;
                    target += 1;
                    index -= 1;
                }
                
                if(index >= 0 && check[index] == target) result[index] = ".";
            }
        }
        // System.out.println(Arrays.toString(result));
        output = String.join("", result);


        return output;
        
        
        
        
        /** Version 1  :  시간초과
        String output = "";
        int size = dominoes.length();
        int[] left = new int[size];
        int[] right = new int[size];
        for (int i = 0; i < size; i++) { // -> right
            if(dominoes.charAt(i) == 'R') {
                right[i] = 1;
            } else if(dominoes.charAt(i) == '.') {
                if(0< i  && right[i-1] >=1){
                    right[i] = right[i-1] + 1;
                } else {
                    right[i] = 0;
                }
            } else {
                right[i] = 0;
            }
        }
        
        for(int i = size-1; i >= 0 ; i-- ){ // <- left
            if(dominoes.charAt(i) == 'L'){
                left[i] = 1;
            } else if(dominoes.charAt(i) == '.') {
                if(i < size-1 && left[i+1] >= 1){
                    left[i] = left[i+1] +1;
                } else {
                    left[i] = 0;
                }
            } else {
                left[i] = 0;
            }
        }
        for(int i = 0; i <size ; i ++) { // compare
            if(left[i] ==0 && right[i] == 0){
                output+= ".";
            } else if (left[i] !=0 && right[i] == 0){
                output += "L";
            } else if (left[i] ==0 && right[i] != 0){
                output += "R";
            } else {
                if(left[i] > right[i]){
                    output += "R";
                } else if(left[i] < right[i]){
                    output += "L";
                } else {
                    output += ".";
                }
            }
        }
        return output;
        */
    }
}