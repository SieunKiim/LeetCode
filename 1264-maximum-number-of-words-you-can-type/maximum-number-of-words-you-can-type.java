class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] arr = text.split(" ");
        Set<Character> set = brokenLetters.chars()
            .mapToObj(c -> (char) c)
            .collect(Collectors.toSet());
        int count = 0;
        System.out.println(set);
        for(String word : arr){
            char[] temp = word.toCharArray();
            for(char c : temp){
                if(set.contains(c)){
                    count += 1;
                    break;
                }
            }
        }
        return arr.length-count;
    }
}