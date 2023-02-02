class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        HashMap<Character, Integer> customOrder = new HashMap<>();
        char[] arr = order.toCharArray();
        int index = 1;
        for(char a: arr){
            customOrder.put(a, index);
            index += 1;
        }
        String[] temp = Arrays.copyOfRange(words, 0, words.length);
        Arrays.sort(temp, (a, b)-> {
            int aSize = a.length();
            int bSize = b.length();
            int i;
            for(i = 0; i < Math.min(aSize, bSize); i++){
                int ac = customOrder.get(a.charAt(i));
                int bc = customOrder.get(b.charAt(i));
                if(ac != bc) return ac-bc;
            }
            return aSize - bSize;
        });
        for(int i =0 ; i<words.length; i++){
            if(!words[i].equals(temp[i])) return false;
        }
        return true; 
    }
}