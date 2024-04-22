class Solution {
    public int openLock(String[] deadends, String target) {
        Map<Character, Character> nextSlot = Map.of(
            '0', '1', 
            '1', '2', 
            '2', '3', 
            '3', '4', 
            '4', '5', 
            '5', '6', 
            '6', '7', 
            '7', '8', 
            '8', '9', 
            '9', '0'
        );
        Map<Character, Character> prevSlot = Map.of(
            '0', '9', 
            '1', '0', 
            '2', '1', 
            '3', '2', 
            '4', '3', 
            '5', '4', 
            '6', '5', 
            '7', '6', 
            '8', '7', 
            '9', '8'
        );

        Set<String> visitedCombinations = new HashSet<>(Arrays.asList(deadends));
        Queue<String> pendingCombinations = new LinkedList<String>();

        int turns = 0;

        if (visitedCombinations.contains("0000")) {
            return -1;
        }

        pendingCombinations.add("0000");
        visitedCombinations.add("0000");

        while (!pendingCombinations.isEmpty()) {
            int currLevelNodesCount = pendingCombinations.size();
            for (int i = 0; i < currLevelNodesCount; i++) {
                String currentCombination = pendingCombinations.poll();

                if (currentCombination.equals(target)) {
                    return turns;
                }

                for (int wheel = 0; wheel < 4; wheel += 1) {
                    StringBuilder newCombination = new StringBuilder(currentCombination);
                    newCombination.setCharAt(wheel, nextSlot.get(newCombination.charAt(wheel)));
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }
                    newCombination = new StringBuilder(currentCombination);
                    newCombination.setCharAt(wheel, prevSlot.get(newCombination.charAt(wheel)));
                    if (!visitedCombinations.contains(newCombination.toString())) {
                        pendingCombinations.add(newCombination.toString());
                        visitedCombinations.add(newCombination.toString());
                    }
                }
            }
            turns += 1;
        }
        return -1;
    }
}