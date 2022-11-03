class Solution {

    public int longestPalindrome(String[] words) {
        int bag[][]=new int[26][26];
        int count=0;
        for(String word:words){
            int a=word.charAt(0)- 'a';
            int b=word.charAt(1)- 'a';
            if(bag[b][a]>0){
                count+=4;
                bag[b][a]--;
            }
            else
                bag[a][b]++;
        }
        for(int i=0;i<26;i++){
            if(bag[i][i]>0)
            {
                count+=2;
                break;
            }
        }
        return count;
        // int count = 0;
        // HashMap<String, Integer> bag = new HashMap<>();
        // HashMap<String, Integer> samesame = new HashMap<>();
        // for(int i = 0; i < words.length;i++){
        //     if(words[i].charAt(0) == words[i].charAt(1)){
        //         int temp = samesame.getOrDefault(words[i], 0);
        //         samesame.put(words[i], temp+1);
        //     } else {
        //         if(bag.containsKey(words[i])){
        //             count += 1;
        //             int temp = bag.get(words[i]);
        //             if (temp-1 == 0)
        //                 bag.remove(words[i]);
        //             else
        //                 bag.put(words[i], temp-1);
        //         } else {
        //             StringBuffer sb = new StringBuffer(words[i]);
        //             String target = sb.reverse().toString();
        //             bag.put(target, bag.getOrDefault(target,0)+1);
        //         }
        //     }
        // }
        // int bigSame = 0;
        // int bigOdd = 0;
        // for(int val : samesame.values()){
        //     if(val%2 == 0)
        //         bigSame += val;
        //     else {
        //         if(val> bigOdd){
        //             bigSame += val;
        //             if(bigOdd != 0)
        //                 bigSame -= 1;
        //             bigOdd= val;
        //         } else
        //             bigSame += (val-1);   
        //     }   
        // }
        // return count * 4 + bigSame * 2;
    }
}