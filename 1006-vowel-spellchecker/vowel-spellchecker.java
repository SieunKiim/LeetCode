class Solution {
    String[] wordArr;
    HashSet<Character> vowelSet = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
    HashMap<String, List<String>> map = new HashMap<>();
    HashSet<String> wordSet;

    public String[] spellchecker(String[] wordlist, String[] queries) {
        String[] answers = new String[queries.length];
        wordSet = new HashSet<>(Arrays.asList(wordlist));
        
        for(int i = 0; i<wordlist.length;i++){
            String key = getConditionString(wordlist[i]);
            List<String> arr = map.getOrDefault(key, new ArrayList<>());
            arr.add(wordlist[i]);
            map.put(key, arr);
        }

        for(int i =0; i<queries.length;i++){
            String tempKey= getConditionString(queries[i]);
            var tempArr = map.getOrDefault(tempKey, new ArrayList<>());
            if(tempArr.isEmpty()){
                 answers[i] = "";
            } else {
                var tempAnswer = "";
                if(wordSet.contains(queries[i])){
                    answers[i] = queries[i];
                    continue;
                }

                for(String tempString : tempArr){
                    if(tempString.toLowerCase().equals(queries[i].toLowerCase())){
                        tempAnswer = tempString;
                        break;
                    }
                }

                if(tempAnswer.length() == 0){
                    tempAnswer = tempArr.get(0);
                }
                answers[i] = tempAnswer;
            }
        }
        return answers;
    }

    private String getConditionString(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < s.length();i++){
            char now = Character.toLowerCase(s.charAt(i));
            if(vowelSet.contains(now)){
                sb.append(".");
            } else {
                sb.append(now);
            }
        }
        return sb.toString();
    }
}