class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Set<Integer> winSet = new HashSet<>();
        Map<Integer,Integer> defeatedCount = new HashMap<>();
        for(int[] match : matches){
            int winner = match[0];
            int loser = match[1];
            defeatedCount.put(loser, defeatedCount.getOrDefault(loser,0)+1);
            if(winSet.contains(loser))
                winSet.remove(loser);
            if(!defeatedCount.containsKey(winner))
                winSet.add(winner);
        }
        
        List<Integer> winners = new ArrayList<>(winSet);
        Collections.sort(winners);
        
        List<Integer> onlyOne = new ArrayList<>();
        for(Map.Entry<Integer, Integer> count : defeatedCount.entrySet()){
            if(count.getValue() == 1){
                onlyOne.add(count.getKey());
            }
        }
        Collections.sort(onlyOne);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(winners);
        answer.add(onlyOne);
        return answer;
    }
}