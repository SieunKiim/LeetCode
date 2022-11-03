class Solution {

    public int longestPalindrome(String[] words) {
        int count = 0;
        // int bigSameOdd = 0;
        HashMap<String, Integer> bag = new HashMap<>();
        HashMap<String, Integer> samesame = new HashMap<>();
        for(int i = 0; i < words.length;i++){
            if(words[i].charAt(0) == words[i].charAt(1)){
                int temp = samesame.getOrDefault(words[i], 0);
                // if((temp + 1)%2 == 1 )
                //     bigSameOdd = Math.max(bigSameOdd, temp + 1);
                samesame.put(words[i], temp+1);
            } else {
                if(bag.containsKey(words[i])){
                    count += 1;
                    int temp = bag.get(words[i]);
                    if (temp-1 == 0){
                        bag.remove(words[i]);
                    }else{
                        bag.put(words[i], temp-1);
                    }
                } else {
                    StringBuffer sb = new StringBuffer(words[i]);
                    String target = sb.reverse().toString();
                    bag.put(target, bag.getOrDefault(target,0)+1);
                }
            }
        }
        int bigSame = 0;
        int bigOdd = 0;
        for(int val : samesame.values()){
            if(val%2 == 0){
                bigSame += val;
            } else {
                if(val> bigOdd){
                    bigSame += val;
                    if(bigOdd != 0){
                        bigSame -= 1;
                    }
                    bigOdd= val;
                } else{
                    bigSame += (val-1);
                }
                
            }
            
        }
        // System.out.println(count +" || "+bigSame);
        // System.out.println(samesame);
        // System.out.println(bag);
        return count * 4 + bigSame * 2;
    }
}